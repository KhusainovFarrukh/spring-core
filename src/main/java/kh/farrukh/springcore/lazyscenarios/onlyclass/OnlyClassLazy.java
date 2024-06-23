package kh.farrukh.springcore.lazyscenarios.onlyclass;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class OnlyClassLazy {

  public OnlyClassLazy() {
    System.out.println("OnlyClassLazy is initialized");
  }

  public void print() {
    System.out.println("OnlyClassLazy.print");
  }

}
