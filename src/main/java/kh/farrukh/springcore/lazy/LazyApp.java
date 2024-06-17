package kh.farrukh.springcore.lazy;

import kh.farrukh.springcore.lazy.bean.LogisticsCompany;
import kh.farrukh.springcore.lazy.bean.PhoneShop;
import kh.farrukh.springcore.lazy.config.LazyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(LazyConfig.class);

    var phoneShop = context.getBean(PhoneShop.class);
    var logisticsCompany = context.getBean(LogisticsCompany.class);

    var samsung = phoneShop.getSamsung();
    System.out.println("Phone brand: " + samsung.brand());
    logisticsCompany.deliver(samsung);

    var iphone = phoneShop.getIphone();
    System.out.println("Phone brand: " + iphone.brand());
    logisticsCompany.deliver(iphone);

//    phoneShop.drive(samsung);
//    phoneShop.drive(iphone);
  }

}
