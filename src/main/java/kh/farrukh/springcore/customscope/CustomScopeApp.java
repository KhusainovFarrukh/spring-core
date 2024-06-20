package kh.farrukh.springcore.customscope;

import kh.farrukh.springcore.customscope.bean.Laptop;
import kh.farrukh.springcore.customscope.config.CustomScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScopeApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(CustomScopeConfig.class);

    var laptop1 = context.getBean(Laptop.class);

    laptop1.setModel("MacBook Pro 2");

    System.out.println("Before saving: " + laptop1);
    laptop1.save();
    laptop1.setModel("MacBook Pro 3");
    laptop1.save();

    System.out.println("Before getting version: " + laptop1);
    System.out.println("Version 1: " + laptop1.getVersion(1));
    System.out.println("Version 2: " + laptop1.getVersion(2));
    laptop1.setModel("MacBook Pro 4");
    System.out.println("Version 3: " + laptop1.getVersion(3));
    laptop1.save();
    System.out.println("Version 4: " + laptop1.getVersion(4));

    System.out.println("Laptop 1: " + laptop1);

    var laptop2 = context.getBean(Laptop.class);
    System.out.println("Laptop 2: " + laptop2);
  }

}
