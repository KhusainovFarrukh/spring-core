package kh.farrukh.springcore.lazyscenarios;

import kh.farrukh.springcore.lazyscenarios.config.LazyScenariosConfig;
import kh.farrukh.springcore.lazyscenarios.onlyclass.OnlyClassLazy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyScenariosApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(LazyScenariosConfig.class);

//    var onlyClassLazy = context.getBean(OnlyClassLazy.class);
//    onlyClassLazy.print();
  }

}
