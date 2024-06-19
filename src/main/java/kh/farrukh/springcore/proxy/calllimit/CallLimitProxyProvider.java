package kh.farrukh.springcore.proxy.calllimit;

import java.util.Map;
import java.util.concurrent.Semaphore;

public interface CallLimitProxyProvider {

  Object getProxy(Object bean, Map<String, Semaphore> semaphores);

}
