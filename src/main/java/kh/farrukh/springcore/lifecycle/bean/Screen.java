package kh.farrukh.springcore.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Screen {

  private final String type;

  public Screen(String type) {
    this.type = type;
    System.out.println("Screen constructor");
  }

  //does not work, because it is not a bean
  @PostConstruct
  public void postConstruct() {
    System.out.println("PostConstruct: Screen postConstruct. type = " + type);
  }

  //does not work, because it is not a bean
  @PreDestroy
  public void preDestroy() {
    System.out.println("PreDestroy: Screen preDestroy. type = " + type);
  }

  @Override
  public String toString() {
    return "Screen{" +
        "type='" + type + '\'' +
        '}';
  }

}
