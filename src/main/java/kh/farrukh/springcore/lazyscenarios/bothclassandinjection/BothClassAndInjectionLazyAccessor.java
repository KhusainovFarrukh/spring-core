package kh.farrukh.springcore.lazyscenarios.bothclassandinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BothClassAndInjectionLazyAccessor {

  private final BothClassAndInjectionLazy bothClassAndInjectionLazy;

  public BothClassAndInjectionLazyAccessor(@Lazy BothClassAndInjectionLazy bothClassAndInjectionLazy) {
    this.bothClassAndInjectionLazy = bothClassAndInjectionLazy;
    System.out.println("BothClassAndInjectionLazyAccessor constructor");
  }

  public void print() {
    System.out.println("BothClassAndInjectionLazyAccessor print method");
    bothClassAndInjectionLazy.print();
  }

}
