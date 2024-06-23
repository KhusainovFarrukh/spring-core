package kh.farrukh.springcore.lazyscenarios.botheagerandlazyinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BothEagerAndLazyInjectionLazyLazyAccessor {

  private final BothEagerAndLazyInjectionLazy bothEagerAndLazyInjectionLazy;

  public BothEagerAndLazyInjectionLazyLazyAccessor(@Lazy BothEagerAndLazyInjectionLazy bothEagerAndLazyInjectionLazy) {
    this.bothEagerAndLazyInjectionLazy = bothEagerAndLazyInjectionLazy;
    System.out.println("BothEagerAndLazyInjectionLazyLazyAccessor is initialized");
  }

  public void print() {
    System.out.println("BothEagerAndLazyInjectionLazyLazyAccessor.print");
    bothEagerAndLazyInjectionLazy.print();
  }

}
