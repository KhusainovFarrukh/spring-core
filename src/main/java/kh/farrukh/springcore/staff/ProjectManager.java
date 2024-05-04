package kh.farrukh.springcore.staff;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProjectManager {

  private final List<String> projects = new ArrayList<>();

  public void manageProject(String projectName) {
    System.out.println("ProjectManager (" + this + ") is managing project: " + projectName);
    projects.add(projectName);
  }

  public List<String> getProjects() {
    return projects;
  }
}
