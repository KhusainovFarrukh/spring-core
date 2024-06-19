package kh.farrukh.springcore.event.bean;

import java.util.Random;
import kh.farrukh.springcore.event.event.Bug;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Software {

  private final ApplicationEventPublisher publisher;

  private static final Random RANDOM = new Random();

  public Software(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  public void start() {
    System.out.println("Software started");

    for (int i = 0; i < 10; i++) {
      int random = RANDOM.nextInt(0, 100);
      publisher.publishEvent(new Bug(this, "Bug " + i, random));
    }

    System.out.println("Software stopped");
  }

}
