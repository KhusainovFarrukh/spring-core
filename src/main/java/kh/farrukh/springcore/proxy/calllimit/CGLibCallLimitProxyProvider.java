package kh.farrukh.springcore.proxy.calllimit;

import java.util.Map;
import java.util.concurrent.Semaphore;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CGLibCallLimitProxyProvider implements CallLimitProxyProvider {

  @Override
  public Object getProxy(Object bean, Map<String, Semaphore> semaphores) {
    var beanClass = bean.getClass();

    var enhancer = new Enhancer();
    enhancer.setSuperclass(beanClass);
    enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
      var qualifier = CallLimitUtils.getQualifier(method, beanClass);
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
    });

    try {
      return enhancer.create(
          new Class[]{String.class},
          new String[]{beanClass.getConstructor(String.class).getName()}
      );
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
