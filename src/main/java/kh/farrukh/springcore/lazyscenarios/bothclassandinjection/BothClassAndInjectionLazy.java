package kh.farrukh.springcore.lazyscenarios.bothclassandinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BothClassAndInjectionLazy {

  public BothClassAndInjectionLazy() {
    System.out.println("BothClassAndInjectionLazy constructor");
  }

  public void print() {
    System.out.println("BothClassAndInjectionLazy print method");
  }

}
