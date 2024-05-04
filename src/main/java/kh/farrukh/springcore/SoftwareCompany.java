package kh.farrukh.springcore;

import java.util.UUID;
import kh.farrukh.springcore.config.SoftwareCompanyConfig;
import kh.farrukh.springcore.office.StaffProvider;
import kh.farrukh.springcore.product.Project;
import kh.farrukh.springcore.staff.BusinessAnalyst;
import kh.farrukh.springcore.staff.ProjectManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SoftwareCompany {

  public static void main(String[] args) {
    System.out.println("SoftwareCompany is working");

    ApplicationContext appContext =
        new AnnotationConfigApplicationContext(SoftwareCompanyConfig.class);

    Project project = appContext.getBean(Project.class);
    project.startProject("Spring Core");

    StaffProvider staffProvider = appContext.getBean(StaffProvider.class);

    ProjectManager projectManager = staffProvider.getProjectManager();
    System.out.println("PM is working on: " + projectManager.getProjects());

    BusinessAnalyst firstBusinessAnalyst = staffProvider.getBusinessAnalyst(UUID.randomUUID());
    BusinessAnalyst secondBusinessAnalyst = staffProvider.getBusinessAnalyst(UUID.randomUUID());

    System.out.println("First BA is working on: " + firstBusinessAnalyst.getTaskId() + " - "
        + firstBusinessAnalyst.getTaskName());
    System.out.println("First BA is working on: " + secondBusinessAnalyst.getTaskId() + " - "
        + secondBusinessAnalyst.getTaskName());

    secondBusinessAnalyst.setTaskName("Hiring a dev team");
    System.out.println("New task is assigned to second BA");

    System.out.println("First BA is working on: " + firstBusinessAnalyst.getTaskId() + " - "
        + firstBusinessAnalyst.getTaskName());
    System.out.println("First BA is working on: " + secondBusinessAnalyst.getTaskId() + " - "
        + secondBusinessAnalyst.getTaskName());

    ProjectManager newProjectManager = staffProvider.getProjectManager();
    System.out.println("New PM is working on: " + newProjectManager.getProjects());

    newProjectManager.manageProject("Spring JPA");
    System.out.println("New project is added to new PM's list");

    System.out.println("PM is working on: " + projectManager.getProjects());
    System.out.println("New PM is working on: " + newProjectManager.getProjects());
  }

}
