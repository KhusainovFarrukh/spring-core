package kh.farrukh.springcore.lifecycle.bean;

import org.springframework.beans.factory.FactoryBean;

public class ScreenFactory implements FactoryBean<Screen> {

  private final String type;

  public ScreenFactory(String type) {
    this.type = type;
    System.out.println("ScreenFactory constructor");
  }

  @Override
  public Screen getObject() {
    return new Screen(type);
  }

  @Override
  public Class<?> getObjectType() {
    return Screen.class;
  }

  private void onInit() {
    System.out.println("ScreenFactory onInit. type = " + type);
  }

  private void onDestroy() {
    System.out.println("ScreenFactory onDestroy. type = " + type);
  }

}
