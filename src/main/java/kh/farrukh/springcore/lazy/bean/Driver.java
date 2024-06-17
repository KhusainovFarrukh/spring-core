package kh.farrukh.springcore.lazy.bean;

import javax.annotation.PostConstruct;
import kh.farrukh.springcore.lazy.bean.PhoneShop.Phone;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Driver {

  private final LogisticsCompany logisticsCompany;

  static {
    System.out.println("Driver static block");
  }

  public Driver(LogisticsCompany logisticsCompany) {
    this.logisticsCompany = logisticsCompany;
    System.out.println("Driver constructor");
  }

  @PostConstruct
  private void init() {
    System.out.println("Driver init method");
  }

  public void drive(Phone phone) {
    System.out.println("Driving phone: " + phone.brand());
    logisticsCompany.informCompany(phone);
  }

}
