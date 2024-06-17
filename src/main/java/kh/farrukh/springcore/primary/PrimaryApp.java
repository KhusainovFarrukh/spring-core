package kh.farrukh.springcore.primary;

import kh.farrukh.springcore.primary.bean.CarShop;
import kh.farrukh.springcore.primary.config.PrimaryConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(PrimaryConfig.class);
    var carShop = context.getBean(CarShop.class);

    carShop.printCars();
  }

}
