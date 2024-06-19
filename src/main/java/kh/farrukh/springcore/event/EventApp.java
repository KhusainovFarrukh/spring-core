package kh.farrukh.springcore.event;

import java.util.Scanner;
import kh.farrukh.springcore.event.bean.Software;
import kh.farrukh.springcore.event.config.EventConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(EventConfig.class);

    var software = context.getBean(Software.class);

    var scanner = new Scanner(System.in);

    software.start();
    scanner.nextLine();
    software.stop();
  }

}
