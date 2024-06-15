package kh.farrukh.springcore.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Laptop implements InitializingBean, DisposableBean {

  @PostConstruct
  public void postConstruct() {
    System.out.println("PostConstruct: Laptop postConstruct");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("PreDestroy: Laptop preDestroy");
  }

  @Override
  public void destroy() {
    System.out.println("DisposableBean: Laptop destroy");
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("InitializingBean: Laptop afterPropertiesSet");
  }

  public void powerOn() {
    System.out.println("Laptop is being powered on");
  }

}
