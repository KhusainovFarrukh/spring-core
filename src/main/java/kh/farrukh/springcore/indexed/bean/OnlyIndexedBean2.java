package kh.farrukh.springcore.indexed.bean;

import javax.annotation.PostConstruct;
import kh.farrukh.springcore.indexed.annotation.IndexedBean;

@IndexedBean
public class OnlyIndexedBean2 {

  @PostConstruct
  public void init() {
    System.out.println("OnlyIndexedBean2 bean is initialized");
  }

  public void hello() {
    System.out.println("Hello from OnlyIndexedBean2 bean");
  }

}
