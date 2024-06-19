package kh.farrukh.springcore.proxy.config;

import kh.farrukh.springcore.proxy.bean.Developer;
import kh.farrukh.springcore.proxy.bean.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kh.farrukh.springcore.proxy")
public class ProxyConfig {

  @Bean
  public Developer john() {
    return new Developer("John");
  }

  @Bean
  public Developer mike() {
    return new Developer("Mike");
  }

  @Bean
  public Project springCore() {
    return new Project("Spring Core");
  }

  @Bean
  public Project springData() {
    return new Project("Spring Data");
  }

  @Bean
  public Project springSecurity() {
    return new Project("Spring Security");
  }

  @Bean
  public Project springBoot() {
    return new Project("Spring Boot");
  }

}
