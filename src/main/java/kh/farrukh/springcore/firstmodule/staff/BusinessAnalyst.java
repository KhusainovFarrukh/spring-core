package kh.farrukh.springcore.firstmodule.staff;

import java.util.UUID;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BusinessAnalyst {

  private UUID taskId;
  private String taskName;

  public BusinessAnalyst(UUID taskId) {
    this.taskId = taskId;
    this.taskName = "Initializing project";
  }

  public void analyze(String projectName, String taskName) {
    System.out.println(
        "BusinessAnalyst (" + this + ") is analyzing: " + taskName + " (" + projectName + ")"
    );
    setTaskName(taskName);
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskId = UUID.randomUUID();
    this.taskName = taskName;
  }

  public UUID getTaskId() {
    return taskId;
  }

}
