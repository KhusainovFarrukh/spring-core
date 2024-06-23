package kh.farrukh.springcore.lazyscenarios.onlyclass;

import org.springframework.stereotype.Component;

@Component
public class OnlyClassLazyAccessor {

  private final OnlyClassLazy onlyClassLazy;

  public OnlyClassLazyAccessor(OnlyClassLazy onlyClassLazy) {
    this.onlyClassLazy = onlyClassLazy;
    System.out.println("OnlyClassLazyAccessor is initialized");
  }

  public void print() {
    System.out.println("OnlyClassLazyAccessor.print");
    onlyClassLazy.print();
  }

}
