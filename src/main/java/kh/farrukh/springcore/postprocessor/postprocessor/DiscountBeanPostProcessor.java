package kh.farrukh.springcore.postprocessor.postprocessor;

import java.util.Objects;
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
      var discountableClass = discountable.getClass();

      var discount = discountableClass.getAnnotation(Discount.class);
      applyDiscount(discountable, discount);

      var discounts = discountableClass.getAnnotation(Discount.List.class);
      if (discounts != null) {
        for (var discountItem : discounts.value()) {
          applyDiscount(discountable, discountItem);
        }
      }
    }

    return bean;
  }

  private void applyDiscount(Discountable discountable, Discount discount) {
    if (discount != null) {
      var qualifier = discount.qualifier();
      if (Objects.equals(qualifier, discountable.getQualifier())) {
        discountable.setDiscount(discount.value());
      }
    }
  }
}
