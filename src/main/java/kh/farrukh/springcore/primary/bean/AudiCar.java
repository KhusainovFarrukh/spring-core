package kh.farrukh.springcore.primary.bean;

import org.springframework.stereotype.Component;

@Component
public class AudiCar implements Car {

  @Override
  public String getProducer() {
    return "Audi";
  }
}
