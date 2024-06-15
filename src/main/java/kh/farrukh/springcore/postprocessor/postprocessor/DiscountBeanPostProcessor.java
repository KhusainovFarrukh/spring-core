package kh.farrukh.springcore.postprocessor.postprocessor;

import kh.farrukh.springcore.postprocessor.discount.Discount;
import kh.farrukh.springcore.postprocessor.discount.Discountable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DiscountBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof Discountable discountable) {
      var discount = discountable.getClass().getAnnotation(Discount.class);
      if (discount != null) {
        discountable.setDiscount(discount.value());
      }
    }

    return bean;
  }
}
