package kh.farrukh.springcore.lazyscenarios.botheagerandlazyinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BothEagerAndLazyInjectionLazy {

  public BothEagerAndLazyInjectionLazy() {
    System.out.println("BothEagerAndLazyInjectionLazy constructor");
  }

  public void print() {
    System.out.println("BothEagerAndLazyInjectionLazy print method");
  }

}
