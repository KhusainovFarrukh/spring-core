package kh.farrukh.springcore.postprocessor.config;

import java.time.LocalTime;
import kh.farrukh.springcore.postprocessor.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class CarListBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    beanFactory.registerSingleton("carShopOpenTime", LocalTime.of(10, 0));
    beanFactory.registerSingleton("carShopCloseTime", LocalTime.of(17, 0));

    addCar("BMW", "Car 1", (DefaultListableBeanFactory) beanFactory);
    addCar("Audi", "Car 2", (DefaultListableBeanFactory) beanFactory);
  }

  private void addCar(String producer, String name, DefaultListableBeanFactory beanFactory) {
    var beanDefinition = new GenericBeanDefinition();
    beanDefinition.setBeanClass(Car.class);
    var args = new ConstructorArgumentValues();
    args.addIndexedArgumentValue(0, producer);
    args.addIndexedArgumentValue(1, name);
    beanDefinition.setConstructorArgumentValues(args);
    var beanName = (producer + name).replace(" ", "_").toLowerCase();
    beanFactory.registerBeanDefinition(beanName, beanDefinition);
  }

}
