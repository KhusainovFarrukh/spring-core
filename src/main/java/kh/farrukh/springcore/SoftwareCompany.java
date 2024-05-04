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

    ProjectManager projectManager = appContext.getBean("projectManager", ProjectManager.class);
    projectManager.manageProject();

    BusinessAnalyst businessAnalyst = appContext.getBean("businessAnalyst", BusinessAnalyst.class);
    businessAnalyst.analyze();
  }

}
