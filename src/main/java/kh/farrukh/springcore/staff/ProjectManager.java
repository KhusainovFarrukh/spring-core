package kh.farrukh.springcore.staff;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProjectManager {

  private final BusinessAnalyst businessAnalyst;

  public ProjectManager(BusinessAnalyst businessAnalyst) {
    this.businessAnalyst = businessAnalyst;
  }

  public void manageProject() {
    System.out.println("ProjectManager is managing project");
    businessAnalyst.analyze();
  }

  public BusinessAnalyst getBusinessAnalyst() {
    return businessAnalyst;
  }
}
