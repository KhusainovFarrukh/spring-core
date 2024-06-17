package kh.farrukh.springcore.lazy.bean;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PhoneShop {

//  private final Driver shopDriver;

  static {
    System.out.println("PhoneShop static block");
  }

  public PhoneShop() {
//  public PhoneShop(Driver shopDriver) {
//    this.shopDriver = shopDriver;
    System.out.println("PhoneShop constructor");
  }

  @PostConstruct
  private void init() {
    System.out.println("PhoneShop init method");
  }

  public Phone getSamsung() {
    return new Phone("Samsung");
  }

  public Phone getIphone() {
    return new Phone("Iphone");
  }

//  public void drive(Phone phone) {
//    System.out.println("Driving (shop) phone: " + phone.brand());
//    shopDriver.drive(phone);
//  }

  public record Phone(
      String brand
  ) {

  }

}
