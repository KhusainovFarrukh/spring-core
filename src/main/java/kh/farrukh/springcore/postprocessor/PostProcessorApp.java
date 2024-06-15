package kh.farrukh.springcore.postprocessor;

import kh.farrukh.springcore.postprocessor.bean.SoftwareEngineer;
import kh.farrukh.springcore.postprocessor.config.PostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(PostProcessorConfig.class);

    var softwareEngineer = context.getBean(SoftwareEngineer.class);
    softwareEngineer.writeCode();
  }

}
