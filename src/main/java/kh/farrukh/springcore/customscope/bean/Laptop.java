package kh.farrukh.springcore.customscope.bean;

import kh.farrukh.springcore.customscope.annotation.GetVersion;
import kh.farrukh.springcore.customscope.annotation.NewVersion;

public class Laptop {

  private String brand;
  private String model;

  public Laptop() {

  }

  public Laptop(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @NewVersion
  public void save() {
  }

  @GetVersion
  public Laptop getVersion(int version) {
    return null;
  }

  @Override
  public String toString() {
    return "Laptop{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        '}';
  }
}
