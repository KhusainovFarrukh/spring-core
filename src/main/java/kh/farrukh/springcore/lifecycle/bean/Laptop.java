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

  private final Screen screen;

  public Laptop(Screen screen) {
    this.screen = screen;
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("PostConstruct: Laptop postConstruct. screen = " + screen);
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("PreDestroy: Laptop preDestroy. screen = " + screen);
  }

  @Override
  public void destroy() {
    System.out.println("DisposableBean: Laptop destroy. screen = " + screen);
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("InitializingBean: Laptop afterPropertiesSet. screen = " + screen);
  }

  public void powerOn() {
    System.out.println("Laptop is being powered on. screen = " + screen);
  }

}
