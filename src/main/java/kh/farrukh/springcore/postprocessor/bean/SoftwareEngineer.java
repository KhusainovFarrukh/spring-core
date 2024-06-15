package kh.farrukh.springcore.postprocessor.bean;

import org.springframework.stereotype.Component;

@Component
public class SoftwareEngineer {

  private boolean hasCoffee;

  public SoftwareEngineer() {
    System.out.println("SoftwareEngineer constructor is called");
  }

  public void setHasCoffee(boolean hasCoffee) {
    this.hasCoffee = hasCoffee;
  }

  public void writeCode() {
    if (hasCoffee) {
      System.out.println("Writing code with coffee");
    } else {
      System.out.println("Can't write code without coffee");
    }
  }

}
