package kh.farrukh.springcore.event.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BugListener implements ApplicationListener<Bug> {

  @Override
  public void onApplicationEvent(Bug event) {
    if (event.getPriority() > 50) {
      System.out.println("BUG!!! " + event);
    } else {
      System.out.println("Warn: " + event);
    }
  }

}
