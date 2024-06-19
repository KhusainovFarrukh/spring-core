package kh.farrukh.springcore.proxy.bean;

import kh.farrukh.springcore.proxy.calllimit.CallLimit;

//@CallLimit(qualifier = "workerAction")
public class Developer implements Worker {

  private final String name;

  public Developer(String name) {
    this.name = name;
  }

  //  @CallLimit(limit = 1, qualifier = "workerAction")
  @CallLimit(limit = 2)
  @Override
  public void startProject(Project project) {
    System.out.println(name + " starts project " + project.getTitle());
    try {
      Thread.sleep(6000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " finishes project " + project.getTitle());
    project.addProgress(50);
  }

  //  @CallLimit(limit = 1, qualifier = "workerAction")
  @CallLimit
  @Override
  public void paySalary() {
    System.out.println(name + " gets salary");
    try {
      Thread.sleep(10000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public String getName() {
    return name;
  }

}
