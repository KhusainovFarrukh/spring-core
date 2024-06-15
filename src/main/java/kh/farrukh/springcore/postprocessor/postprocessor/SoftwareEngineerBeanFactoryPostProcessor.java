package kh.farrukh.springcore.postprocessor.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SoftwareEngineerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
//    var softwareEngineer = beanFactory.getBean(SoftwareEngineer.class);
//    softwareEngineer.setHasCoffee(true);
    var beanDefinition = beanFactory.getBeanDefinition("softwareEngineer");
    var propertyValues = beanDefinition.getPropertyValues();
    propertyValues.add("hasCoffee", true);
  }

}
