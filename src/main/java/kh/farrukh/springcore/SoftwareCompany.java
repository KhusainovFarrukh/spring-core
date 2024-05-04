package kh.farrukh.springcore;

import kh.farrukh.springcore.config.SoftwareCompanyConfig;
import kh.farrukh.springcore.product.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SoftwareCompany {

  public static void main(String[] args) {
    System.out.println("SoftwareCompany is working");

    ApplicationContext appContext =
        new AnnotationConfigApplicationContext(SoftwareCompanyConfig.class);

    Project project = appContext.getBean(Project.class);
    project.startProject("Spring Core");
  }

}
