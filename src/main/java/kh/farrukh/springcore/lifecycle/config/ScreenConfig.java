package kh.farrukh.springcore.lifecycle.config;

import kh.farrukh.springcore.lifecycle.bean.ScreenFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScreenConfig {

  @Bean(initMethod = "onInit", destroyMethod = "onDestroy")
  public ScreenFactory ips() {
    return new ScreenFactory("ips");
  }

  @Bean ScreenFactory led() {
    return new ScreenFactory("led");
  }

}
