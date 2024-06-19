package kh.farrukh.springcore.proxy.calllimit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CallLimitBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    var callLimits = CallLimitUtils.getCallLimits(bean);

    if (callLimits.isEmpty()) {
      return bean;
    }

    return createProxy(bean, callLimits);
  }

  private Object createProxy(Object bean, Map<String, CallLimit> callLimits) {
    var beanClass = bean.getClass();
    var interfaces = beanClass.getInterfaces();

    var semaphoreMap = callLimits.entrySet().stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        entry -> new Semaphore(entry.getValue().limit())
    ));

    if (interfaces.length != 0) {
      return new JDKDynamicCallLimitProxyProvider().getProxy(bean, semaphoreMap);
    }

    return new CGLibCallLimitProxyProvider().getProxy(bean, semaphoreMap);
  }
}
