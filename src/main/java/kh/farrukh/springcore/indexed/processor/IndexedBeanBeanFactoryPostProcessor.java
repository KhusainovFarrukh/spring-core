package kh.farrukh.springcore.indexed.processor;

import java.beans.Introspector;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kh.farrukh.springcore.indexed.annotation.IndexedBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class IndexedBeanBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    if (beanFactory instanceof DefaultListableBeanFactory defaultListableBeanFactory) {
      var basePackages = getBasePackages(beanFactory);
      var classes = getBeanDefinitions(basePackages);
      registerIndexedBeans(defaultListableBeanFactory, classes);
    } else {
      System.out.println("BeanFactory is not DefaultListableBeanFactory");
    }
  }

  private Set<String> getBasePackages(ConfigurableListableBeanFactory beanFactory) {
    var componentScanBeanNames = beanFactory.getBeanNamesForAnnotation(ComponentScan.class);
    if (componentScanBeanNames.length == 0) {
      throw new RuntimeException("No beans with @ComponentScan annotation found");
    }

    var basePackages = new LinkedHashSet<String>();

    for (String beanName : componentScanBeanNames) {
      var componentScan = beanFactory.findAnnotationOnBean(beanName, ComponentScan.class);
      Optional.ofNullable(componentScan)
          .map(ComponentScan::basePackages)
          .map(List::of)
          .ifPresent(basePackages::addAll);
    }

    return basePackages;
  }

  private List<BeanDefinition> getBeanDefinitions(Set<String> basePackages) {
    var scanner = new ClassPathScanningCandidateComponentProvider(false);
    scanner.addIncludeFilter(new AnnotationTypeFilter(IndexedBean.class));

    return basePackages.stream()
        .map(scanner::findCandidateComponents)
        .flatMap(Set::stream)
        .toList();
  }

  private void registerIndexedBeans(
      DefaultListableBeanFactory beanFactory,
      List<BeanDefinition> classes
  ) {
    for (var beanDefinition : classes) {
      var beanName = Optional
          .ofNullable(Introspector.decapitalize(beanDefinition.getBeanClassName()))
          .orElseGet(beanDefinition::getBeanClassName);
      beanFactory.registerBeanDefinition(beanName, beanDefinition);
    }
  }

}

