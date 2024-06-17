package kh.farrukh.springcore.primary.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarShop {

  @Autowired
  private Car bmwCar;

  @Autowired
  private Car audiCar;

  @Autowired
  @Qualifier("bmwCar")
  private Car defaultCar;

//  public CarShop(Car bmwCar, Car audiCar, @Qualifier("bmwCar") Car defaultCar) {
//    this.bmwCar = bmwCar;
//    this.audiCar = audiCar;
//    this.defaultCar = defaultCar;
//  }

  public void printCars() {
    System.out.println("BMW: " + bmwCar.getProducer());
    System.out.println("Audi: " + audiCar.getProducer());
    System.out.println("Default: " + defaultCar.getProducer());
  }
}
