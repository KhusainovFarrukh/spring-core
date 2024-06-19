package kh.farrukh.springcore.eventadvanced.listener;

import java.time.LocalDateTime;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommentListener {

  @EventListener(String.class)
  private void onComment(String comment) {
    var now = LocalDateTime.now();
    System.out.println(now + " : " + comment);
  }
  
}
