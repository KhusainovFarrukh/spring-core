package kh.farrukh.springcore.staff;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BusinessAnalyst {

  public void analyze() {
    System.out.println("BusinessAnalyst is analyzing");
  }

}
