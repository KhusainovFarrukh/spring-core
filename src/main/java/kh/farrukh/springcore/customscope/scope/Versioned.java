package kh.farrukh.springcore.customscope.scope;

import java.util.HashMap;
import java.util.Map;
import kh.farrukh.springcore.customscope.annotation.GetVersion;
import kh.farrukh.springcore.customscope.annotation.NewVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class Versioned implements Scope {

  public static final String NAME = "versioned";

  private final Map<String, Map<Integer, Object>> beans = new HashMap<>();

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    var versions = beans.computeIfAbsent(name, k -> new HashMap<>());

    if (versions.isEmpty()) {
      var bean = objectFactory.getObject();
      var proxy = createProxy(name, bean);
      versions.put(1, proxy);
      return proxy;
    }

    var lastVersion = versions.keySet().stream().max(Integer::compareTo).orElse(0);
    return versions.get(lastVersion);
  }

  @Override
  public Object remove(String name) {
    return beans.remove(name);
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {

  }

  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  public String getConversationId() {
    return "";
  }

  private Object createProxy(String beanName, Object bean) {
    var enhancer = new Enhancer();
    enhancer.setSuperclass(bean.getClass());
    enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
      var result = method.invoke(bean, args);

      if (method.isAnnotationPresent(NewVersion.class)) {
        var newBean = bean.getClass().getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(bean, newBean);
        var newProxy = createProxy(beanName, newBean);
        var versions = beans.computeIfAbsent(beanName, k -> new HashMap<>());
        var lastVersion = versions.keySet().stream().max(Integer::compareTo).orElse(0);
        versions.put(lastVersion + 1, newProxy);
      }

      if (method.isAnnotationPresent(GetVersion.class)) {
        if (args.length != 1) {
          throw new IllegalArgumentException("Method getVersion should have one argument");
        }
        if (args[0].getClass() != Integer.class) {
          throw new IllegalArgumentException("Argument should be of type Integer");
        }

        var version = (int) args[0];
        var versions = beans.get(beanName);
        return versions.get(version);
      }

      return result;
    });
    return enhancer.create();
  }

}
