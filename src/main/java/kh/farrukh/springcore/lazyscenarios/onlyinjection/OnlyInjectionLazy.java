package kh.farrukh.springcore.lazyscenarios.onlyinjection;

import org.springframework.stereotype.Component;

@Component
public class OnlyInjectionLazy {

  public OnlyInjectionLazy() {
    System.out.println("OnlyInjectionLazy is initialized");
  }

  public void print() {
    System.out.println("OnlyInjectionLazy.print");
  }

}
