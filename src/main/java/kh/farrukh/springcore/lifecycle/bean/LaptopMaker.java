package kh.farrukh.springcore.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LaptopMaker implements InitializingBean, DisposableBean {

  public LaptopMaker() {
    System.out.println("LaptopMaker constructor");
  }

  public void makeLaptop() {
    System.out.println("Laptop is being made");
  }

  @PostConstruct
  public void postConstruct2() {
    System.out.println("PostConstruct: LaptopMaker postConstruct2");
  }

  @PostConstruct
  public void postConstruct1() {
    System.out.println("PostConstruct: LaptopMaker postConstruct1");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("PreDestroy: LaptopMaker preDestroy");
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("InitializingBean: LaptopMaker afterPropertiesSet");
  }

  @Override
  public void destroy() {
    System.out.println("DisposableBean: LaptopMaker destroy");
  }

}
