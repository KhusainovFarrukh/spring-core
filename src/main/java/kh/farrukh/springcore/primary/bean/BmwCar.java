package kh.farrukh.springcore.primary.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class BmwCar implements Car {

  @Override
  public String getProducer() {
    return "BMW";
  }
}
