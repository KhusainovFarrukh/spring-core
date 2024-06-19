package kh.farrukh.springcore.proxy.calllimit;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.Semaphore;
import org.springframework.stereotype.Component;

@Component
public class JDKDynamicCallLimitProxyProvider implements CallLimitProxyProvider {

  @Override
  public Object getProxy(Object bean, Map<String, Semaphore> semaphores) {
    var beanClass = bean.getClass();

    return Proxy.newProxyInstance(
        beanClass.getClassLoader(),
        beanClass.getInterfaces(),
        (proxy, method, args) -> {
          var beanMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
          var qualifier = CallLimitUtils.getQualifier(beanMethod, beanClass);
          var semaphore = semaphores.get(qualifier);

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
}
