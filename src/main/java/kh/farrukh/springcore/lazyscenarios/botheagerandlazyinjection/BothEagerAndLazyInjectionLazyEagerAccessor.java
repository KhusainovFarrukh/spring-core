package kh.farrukh.springcore.lazyscenarios.botheagerandlazyinjection;

import org.springframework.stereotype.Component;

@Component
public class BothEagerAndLazyInjectionLazyEagerAccessor {

  private final BothEagerAndLazyInjectionLazy bothEagerAndLazyInjectionLazy;

  public BothEagerAndLazyInjectionLazyEagerAccessor(BothEagerAndLazyInjectionLazy bothEagerAndLazyInjectionLazy) {
    this.bothEagerAndLazyInjectionLazy = bothEagerAndLazyInjectionLazy;
    System.out.println("BothEagerAndLazyInjectionLazyEagerAccessor is initialized");
  }

  public void print() {
    System.out.println("BothEagerAndLazyInjectionLazyEagerAccessor.print");
    bothEagerAndLazyInjectionLazy.print();
  }

}
