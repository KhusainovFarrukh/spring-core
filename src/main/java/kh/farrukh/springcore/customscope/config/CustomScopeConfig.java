package kh.farrukh.springcore.customscope.config;

import kh.farrukh.springcore.customscope.bean.Laptop;
import kh.farrukh.springcore.customscope.scope.Versioned;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("kh.farrukh.springcore.customscope")
public class CustomScopeConfig {

  @Bean
  @Scope(Versioned.NAME)
  public Laptop laptop() {
    return new Laptop("Apple", "MacBook Pro 1");
  }

}
