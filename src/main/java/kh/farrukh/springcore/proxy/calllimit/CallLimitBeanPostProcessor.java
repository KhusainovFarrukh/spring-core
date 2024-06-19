package kh.farrukh.springcore.proxy.calllimit;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CallLimitBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    var callLimits = getCallLimits(bean);

    if (callLimits.isEmpty()) {
      return bean;
    }

    return createProxy(bean, callLimits);
  }

  private Map<String, CallLimit> getCallLimits(Object bean) {
    var beanClass = bean.getClass();
    var classCallLimit = beanClass.getAnnotation(CallLimit.class);
    var methods = beanClass.getMethods();

    var callLimits = new HashMap<String, CallLimit>();

    for (var method : methods) {
      var methodCallLimit = method.getAnnotation(CallLimit.class);
      var qualifier = getQualifier(method, beanClass);

      if (methodCallLimit != null) {
        callLimits.put(qualifier, methodCallLimit);
      } else if (classCallLimit != null) {
        callLimits.put(qualifier, classCallLimit);
      }
    }

    return callLimits;
  }

  private Object createProxy(Object bean, Map<String, CallLimit> callLimits) {
    var beanClass = bean.getClass();
    var interfaces = beanClass.getInterfaces();

    var semaphoreMap = callLimits.entrySet().stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        entry -> new Semaphore(entry.getValue().limit())
    ));

    if (interfaces.length != 0) {
      return createProxyWithJDKDynamic(bean, semaphoreMap);
    }

    throw new IllegalArgumentException("Bean must implement at least one interface");
  }

  private Object createProxyWithJDKDynamic(
      Object bean,
      Map<String, Semaphore> semaphoreMap
  ) {
    var beanClass = bean.getClass();

    return Proxy.newProxyInstance(
        beanClass.getClassLoader(),
        beanClass.getInterfaces(),
        (proxy, method, args) -> {
          var beanMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
          var qualifier = getQualifier(beanMethod, beanClass);
          var semaphore = semaphoreMap.get(qualifier);

          if (semaphore == null) {
            return method.invoke(bean, args);
          }

          try {
            semaphore.acquire();
            return method.invoke(bean, args);
          } finally {
            semaphore.release();
          }
        }
    );
  }

  private String getQualifier(Method method, Class<?> beanClass) {
    return Optional.ofNullable(method)
        .map(m -> m.getAnnotation(CallLimit.class))
        .map(CallLimit::qualifier)
        .filter(qualifier -> !qualifier.isBlank())
        .orElseGet(() -> getQualifierFromClass(method, beanClass));
  }

  private String getQualifierFromClass(Method method, Class<?> beanClass) {
    return Optional.ofNullable(beanClass)
        .map(c -> c.getAnnotation(CallLimit.class))
        .map(CallLimit::qualifier)
        .filter(qualifier -> !qualifier.isBlank())
        .orElseGet(() -> Optional.ofNullable(method).map(Method::getName).orElse(null));
  }

}
