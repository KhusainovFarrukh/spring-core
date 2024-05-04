package kh.farrukh.springcore.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectManager {

  private BusinessAnalyst businessAnalyst;

  @Autowired
  public void setBusinessAnalyst(BusinessAnalyst businessAnalyst) {
    this.businessAnalyst = businessAnalyst;
  }

  public void manageProject(String projectName) {
    System.out.println("ProjectManager (" + this + ") is managing project: " + projectName);
    businessAnalyst.analyze(projectName);
  }

}
