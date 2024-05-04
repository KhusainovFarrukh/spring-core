package kh.farrukh.springcore.product;

import kh.farrukh.springcore.staff.ProjectManager;
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
