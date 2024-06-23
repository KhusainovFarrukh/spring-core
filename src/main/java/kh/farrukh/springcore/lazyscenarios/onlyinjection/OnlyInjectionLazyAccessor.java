package kh.farrukh.springcore.lazyscenarios.onlyinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OnlyInjectionLazyAccessor {

  private final OnlyInjectionLazy onlyInjectionLazy;

  public OnlyInjectionLazyAccessor(@Lazy OnlyInjectionLazy onlyInjectionLazy) {
    this.onlyInjectionLazy = onlyInjectionLazy;
    System.out.println("OnlyInjectionLazyAccessor is initialized");
  }

  public void print() {
    System.out.println("OnlyInjectionLazyAccessor.print");
    onlyInjectionLazy.print();
  }

}
