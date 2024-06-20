package kh.farrukh.springcore.indexed.bean;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Indexed;

@Indexed
public class OnlyIndexed {

  @PostConstruct
  public void init() {
    System.out.println("OnlyIndexed bean is initialized");
  }

  public void hello() {
    System.out.println("Hello from OnlyIndexed bean");
  }

}
