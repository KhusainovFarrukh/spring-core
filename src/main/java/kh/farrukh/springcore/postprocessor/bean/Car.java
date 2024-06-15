package kh.farrukh.springcore.postprocessor.bean;

public class Car {

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

}
