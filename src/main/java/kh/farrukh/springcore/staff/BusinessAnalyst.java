package kh.farrukh.springcore.staff;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BusinessAnalyst {

  public void analyze(String projectName) {
    System.out.println("BusinessAnalyst (" + this + ") is analyzing: " + projectName);
  }

}
