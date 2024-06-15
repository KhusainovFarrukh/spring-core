package kh.farrukh.springcore.postprocessor.bean;

import kh.farrukh.springcore.postprocessor.discount.Discount;
import kh.farrukh.springcore.postprocessor.discount.Discountable;

@Discount.List({
    @Discount(value = 10, qualifier = "BMW"),
    @Discount(value = 20, qualifier = "Audi")
})
public class Car extends Discountable {

  private final String producer;

  private final String name;

  public Car(String producer, String name) {
    this.producer = producer;
    this.name = name;
  }

  public String getProducer() {
    return producer;
  }

  public String getName() {
    return name;
  }

  @Override
  public String getQualifier() {
    return producer;
  }

}
