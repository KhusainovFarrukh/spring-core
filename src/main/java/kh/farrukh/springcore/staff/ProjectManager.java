package kh.farrukh.springcore.staff;

import org.springframework.stereotype.Component;

@Component
public class ProjectManager {

  private final BusinessAnalyst businessAnalyst;

  public ProjectManager(BusinessAnalyst businessAnalyst) {
    this.businessAnalyst = businessAnalyst;
  }

  public void manageProject(String projectName) {
    System.out.println("ProjectManager (" + this + ") is managing project: " + projectName);
    businessAnalyst.analyze(projectName);
  }

}
