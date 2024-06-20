package kh.farrukh.springcore.indexed;

import kh.farrukh.springcore.indexed.bean.OnlyComponent;
import kh.farrukh.springcore.indexed.bean.OnlyIndexed;
import kh.farrukh.springcore.indexed.bean.OnlyIndexedBean;
import kh.farrukh.springcore.indexed.config.IndexedConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IndexedApp {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(IndexedConfig.class);

//    var onlyIndexed = context.getBean(OnlyIndexed.class);
//    onlyIndexed.hello();
    var onlyComponent = context.getBean(OnlyComponent.class);
    onlyComponent.hello();
    var onlyIndexedBean = context.getBean(OnlyIndexedBean.class);
    onlyIndexedBean.hello();
  }

}
