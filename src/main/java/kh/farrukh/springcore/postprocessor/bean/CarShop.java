package kh.farrukh.springcore.postprocessor.bean;

import java.time.LocalTime;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CarShop {

  private final Map<String, LocalTime> shopTimes;

  private final Map<String, Car> cars;


  public CarShop(Map<String, LocalTime> shopTimes, Map<String, Car> cars) {
    this.shopTimes = shopTimes;
    this.cars = cars;
  }

  public void printCarList() {
    shopTimes.forEach((key, value) -> System.out.println(key + " : " + value));
    cars.forEach((key, value) -> System.out.println(
        key + " : " + value.getProducer() + " - " + value.getName()));
  }

}
