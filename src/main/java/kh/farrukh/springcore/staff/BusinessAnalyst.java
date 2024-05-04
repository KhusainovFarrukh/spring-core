package kh.farrukh.springcore.staff;

import org.springframework.stereotype.Component;

@Component("componentBusinessAnalyst")
public class BusinessAnalyst {

  public void analyze() {
    System.out.println("BusinessAnalyst (" + this + ") is analyzing");
  }

}
