package kh.farrukh.springcore.product;

import kh.farrukh.springcore.staff.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Project {

  private ProjectManager projectManager;

  @Autowired
  public void setProjectManager(ProjectManager projectManager) {
    this.projectManager = projectManager;
  }

  public void startProject(String projectName) {
    projectManager.manageProject(projectName);
  }

}
