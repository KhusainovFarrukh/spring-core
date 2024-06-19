package kh.farrukh.springcore.proxy.bean;

import kh.farrukh.springcore.proxy.calllimit.CallLimit;

public class Project {

  private final String title;
  private Integer progress = 0;

  public Project(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @CallLimit
  public void addProgress(Integer progress) {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    this.progress += progress;
    System.out.println("Project " + title + " progress: " + this.progress + "%");
    if (this.progress >= 100) {
      System.out.println("Project " + title + " is completed");
    }
  }

}
