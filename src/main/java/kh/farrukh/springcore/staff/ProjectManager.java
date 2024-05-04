package kh.farrukh.springcore.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectManager {

  @Autowired
  private BusinessAnalyst businessAnalyst;

  public void manageProject(String projectName) {
    System.out.println("ProjectManager (" + this + ") is managing project: " + projectName);
    businessAnalyst.analyze(projectName);
  }

}
