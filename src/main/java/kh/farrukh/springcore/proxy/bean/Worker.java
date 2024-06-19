package kh.farrukh.springcore.proxy.bean;

import kh.farrukh.springcore.proxy.calllimit.CallLimit;

public interface Worker {

  @CallLimit(limit = 1, qualifier = "workerAction")
  void startProject(Project project);

  @CallLimit(limit = 1, qualifier = "workerAction")
  void paySalary();

}
