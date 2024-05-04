package kh.farrukh.springcore.config;

import java.util.UUID;
import kh.farrukh.springcore.staff.BusinessAnalyst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutStaffConfig {

  @Bean("outStaffBusinessAnalyst")
  public BusinessAnalyst outStaffBusinessAnalyst() {
    return new BusinessAnalyst(UUID.randomUUID());
  }

}
