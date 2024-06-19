package kh.farrukh.springcore.event.bean;

import java.util.Random;
import kh.farrukh.springcore.event.event.Bug;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Software {

  private final ApplicationEventPublisher publisher;

  private boolean running = false;
  private static final Random RANDOM = new Random();

  public Software(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  public void start() {
    System.out.println("Software started");
    System.out.println("Press Enter to stop the software");

    running = true;
    new Thread(this::generateBugs).start();
  }

  private void generateBugs() {
    while (running) {
      int random = RANDOM.nextInt(0, 100);
      publisher.publishEvent(new Bug(this, "Bug with priority " + random, random));
      try {
        Thread.sleep(2000L);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void stop() {
    running = false;

    System.out.println("Software stopped");
  }

}
