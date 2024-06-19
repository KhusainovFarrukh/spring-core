package kh.farrukh.springcore.proxy.calllimit;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CallLimitUtils {

  public static Map<String, CallLimit> getCallLimits(Object bean) {
    var beanClass = bean.getClass();
    var classCallLimit = beanClass.getAnnotation(CallLimit.class);
    var methods = beanClass.getMethods();

    var callLimits = new HashMap<String, CallLimit>();

    for (var method : methods) {
      var methodCallLimit = method.getAnnotation(CallLimit.class);
      var qualifier = CallLimitUtils.getQualifier(method, beanClass);

      if (methodCallLimit != null) {
        callLimits.put(qualifier, methodCallLimit);
      } else if (classCallLimit != null) {
        callLimits.put(qualifier, classCallLimit);
      }
    }

    return callLimits;
  }

  public static String getQualifier(Method method, Class<?> beanClass) {
    return Optional.ofNullable(method)
        .map(m -> m.getAnnotation(CallLimit.class))
        .map(CallLimit::qualifier)
        .filter(qualifier -> !qualifier.isBlank())
        .orElseGet(() -> getQualifierFromClass(method, beanClass));
  }

  private static String getQualifierFromClass(Method method, Class<?> beanClass) {
    return Optional.ofNullable(beanClass)
        .map(c -> c.getAnnotation(CallLimit.class))
        .map(CallLimit::qualifier)
        .filter(qualifier -> !qualifier.isBlank())
        .orElseGet(() -> Optional.ofNullable(method).map(Method::getName).orElse(null));
  }

}
