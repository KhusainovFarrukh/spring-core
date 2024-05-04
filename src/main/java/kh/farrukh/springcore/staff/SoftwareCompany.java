package kh.farrukh.springcore.staff;

public class SoftwareCompany {

  public static void main(String[] args) {
    System.out.println("SoftwareCompany is working");

    ProjectManager projectManager = new ProjectManager();
    projectManager.manageProject();

    BusinessAnalyst businessAnalyst = new BusinessAnalyst();
    businessAnalyst.analyze();
  }

}
