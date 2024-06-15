package kh.farrukh.springcore.postprocessor.postprocessor;

import java.time.LocalTime;
import kh.farrukh.springcore.postprocessor.bean.CarShop;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CarShopOpenTimeBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof CarShop carShop) {
      carShop.setOpenTime(LocalTime.of(11, 0));
    }
    return bean;
  }
}
