package kh.farrukh.springcore.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LaptopMaker {

  public LaptopMaker() {
    System.out.println("LaptopMaker constructor");
  }

  public void makeLaptop() {
    System.out.println("Laptop is being made");
  }

  @PostConstruct
  public void init2() {
    System.out.println("PostConstruct: LaptopMaker init 2");
  }

  @PostConstruct
  public void init1() {
    System.out.println("PostConstruct: LaptopMaker init 1");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("PreDestroy: LaptopMaker destroy");
  }

}
