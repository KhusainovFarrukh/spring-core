package kh.farrukh.springcore.indexed.bean;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class OnlyComponent {

  @PostConstruct
  public void init() {
    System.out.println("OnlyComponent bean is initialized");
  }

  public void hello() {
    System.out.println("Hello from OnlyComponent bean");
  }

}
