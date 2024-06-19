package kh.farrukh.springcore.event.event;

import org.springframework.context.ApplicationEvent;

public class Bug extends ApplicationEvent {

  private final String message;

  private final Integer priority;

  public Bug(Object source, String message, Integer priority) {
    super(source);
    this.message = message;
    if (priority < 0) {
      this.priority = 0;
    } else if (priority > 100) {
      this.priority = 100;
    } else {
      this.priority = priority;
    }
  }

  public String getMessage() {
    return message;
  }

  public Integer getPriority() {
    return priority;
  }

  @Override
  public String toString() {
    return "Bug [message=" + message + ", priority=" + priority + "]";
  }

}
