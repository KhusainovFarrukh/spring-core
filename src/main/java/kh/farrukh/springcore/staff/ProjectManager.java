package kh.farrukh.springcore.staff;

import org.springframework.stereotype.Component;

@Component("componentProjectManager")
public class ProjectManager {

  public void manageProject() {
    System.out.println("ProjectManager is managing project");
  }

}
