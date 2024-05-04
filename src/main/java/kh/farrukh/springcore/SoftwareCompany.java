package kh.farrukh.springcore;

import kh.farrukh.springcore.config.SoftwareCompanyConfig;
import kh.farrukh.springcore.staff.BusinessAnalyst;
import kh.farrukh.springcore.staff.ProjectManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SoftwareCompany {

  public static void main(String[] args) {
    System.out.println("SoftwareCompany is working");

    ApplicationContext appContext =
        new AnnotationConfigApplicationContext(SoftwareCompanyConfig.class);

    BusinessAnalyst businessAnalyst1 = appContext.getBean(BusinessAnalyst.class);
    businessAnalyst1.analyze();
    System.out.println("First BA from getBean: " + businessAnalyst1);

    ProjectManager projectManager1 = appContext.getBean(ProjectManager.class, businessAnalyst1);
    projectManager1.manageProject();
    System.out.println("First PM from getBean: " + projectManager1);
    System.out.println("BA from first PM: " + projectManager1.getBusinessAnalyst());

    BusinessAnalyst businessAnalyst2 = appContext.getBean(BusinessAnalyst.class);
    businessAnalyst2.analyze();
    System.out.println("Second BA from getBean: " + businessAnalyst2);

    ProjectManager projectManager2 = appContext.getBean(ProjectManager.class, businessAnalyst2);
    projectManager2.manageProject();
    System.out.println("Second PM from getBean: " + projectManager2);
    System.out.println("BA from second PM: " + projectManager2.getBusinessAnalyst());
  }

}
