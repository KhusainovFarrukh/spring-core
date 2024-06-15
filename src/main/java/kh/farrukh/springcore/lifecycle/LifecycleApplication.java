package kh.farrukh.springcore.lifecycle;

import kh.farrukh.springcore.lifecycle.bean.LaptopMaker;
import kh.farrukh.springcore.lifecycle.config.LifecycleAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleApplication {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(LifecycleAppConfig.class);

    var laptopMaker = context.getBean(LaptopMaker.class);
    laptopMaker.makeLaptop("ips");
    laptopMaker.makeLaptop("led");
    laptopMaker.makeLaptop("oled");

    context.close();
  }

}
