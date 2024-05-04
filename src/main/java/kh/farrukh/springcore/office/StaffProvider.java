package kh.farrukh.springcore.office;

import java.util.UUID;
import kh.farrukh.springcore.staff.BusinessAnalyst;
import kh.farrukh.springcore.staff.ProjectManager;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class StaffProvider {

  private final ObjectProvider<ProjectManager> projectManagers;

  private final ObjectProvider<BusinessAnalyst> businessAnalysts;

  public StaffProvider(
      ObjectProvider<ProjectManager> projectManagers,
      ObjectProvider<BusinessAnalyst> businessAnalysts
  ) {
    this.projectManagers = projectManagers;
    this.businessAnalysts = businessAnalysts;
  }

  public ProjectManager getProjectManager() {
    return projectManagers.getObject();
  }

  public BusinessAnalyst getBusinessAnalyst(UUID taskId) {
    return businessAnalysts.getObject(taskId);
  }


}
