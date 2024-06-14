package kh.farrukh.springcore.firstmodule.product;

import kh.farrukh.springcore.firstmodule.staff.ProjectManager;
import org.springframework.stereotype.Component;

@Component
public class Project {

  private final ProjectManager projectManager;

  public Project(ProjectManager projectManager) {
    this.projectManager = projectManager;
  }

  public void startProject(String projectName) {
    projectManager.manageProject(projectName);
  }

}
