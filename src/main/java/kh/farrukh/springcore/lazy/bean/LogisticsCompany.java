package kh.farrukh.springcore.lazy.bean;

import javax.annotation.PostConstruct;
import kh.farrukh.springcore.lazy.bean.PhoneShop.Phone;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LogisticsCompany {

  private final Driver driver;

  static {
    System.out.println("LogisticsCompany static block");
  }

  public LogisticsCompany(@Lazy Driver driver) {
    this.driver = driver;
    System.out.println("LogisticsCompany constructor");
  }

  @PostConstruct
  private void init() {
    System.out.println("LogisticsCompany init method");
  }

  public void deliver(Phone phone) {
    System.out.println("Delivering phone: " + phone.brand());
    driver.drive(phone);
  }

  public void informCompany(Phone phone) {
    System.out.println("Informing company about phone: " + phone.brand());
  }

}
