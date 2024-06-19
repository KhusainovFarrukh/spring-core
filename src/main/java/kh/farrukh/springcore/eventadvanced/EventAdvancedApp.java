package kh.farrukh.springcore.eventadvanced;

import java.util.Scanner;
import kh.farrukh.springcore.eventadvanced.config.EventAdvancedConfig;
import kh.farrukh.springcore.eventadvanced.http.CommentHttpServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventAdvancedApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(EventAdvancedConfig.class);

    var scanner = new Scanner(System.in);
    System.out.println("Press Enter to exit");
    scanner.nextLine();

    var commentHttpServer = context.getBean(CommentHttpServer.class);
    commentHttpServer.stopServer();
  }

}
