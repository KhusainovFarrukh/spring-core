package kh.farrukh.springcore.proxy;

import java.util.Collection;
import kh.farrukh.springcore.proxy.bean.Project;
import kh.farrukh.springcore.proxy.bean.Worker;
import kh.farrukh.springcore.proxy.config.ProxyConfig;
import kh.farrukh.springcore.util.CGLibUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyApp {

  public static void main(String[] args) {
    CGLibUtils.initGeneratedClassHandler("build/cglib/proxy");
    var context = new AnnotationConfigApplicationContext(ProxyConfig.class);

    var projects = context.getBeansOfType(Project.class).values();
    var developers = context.getBeansOfType(Worker.class).values();

    new Thread(() -> startProjects(developers, projects)).start();
    paySalary(developers);
  }

  private static void startProjects(Collection<Worker> developers, Collection<Project> projects) {
    for (var developer : developers) {
      for (var project : projects) {
        new Thread(() -> developer.startProject(project)).start();
      }
    }
  }

  private static void paySalary(Collection<Worker> developers) {
    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        for (var developer : developers) {
          new Thread(developer::paySalary).start();
        }
      }).start();
    }
  }

}
