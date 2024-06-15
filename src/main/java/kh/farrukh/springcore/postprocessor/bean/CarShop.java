package kh.farrukh.springcore.postprocessor.bean;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CarShop {

  private final Map<String, Car> cars;


  public CarShop(Map<String, Car> cars) {
    this.cars = cars;
  }

  public void printCarList() {
    cars.forEach((key, value) -> System.out.println(
        key + " : " + value.getProducer() + " - " + value.getName()));
  }

}
