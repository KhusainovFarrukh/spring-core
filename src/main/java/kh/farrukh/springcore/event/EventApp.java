package kh.farrukh.springcore.event;

import kh.farrukh.springcore.event.bean.Software;
import kh.farrukh.springcore.event.config.EventConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(EventConfig.class);

    var software = context.getBean(Software.class);
    software.start();

  }

}
