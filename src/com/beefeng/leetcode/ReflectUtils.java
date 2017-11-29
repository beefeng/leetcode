package com.beefeng.leetcode;

import java.lang.reflect.Method;

public class ReflectUtils {
  public static Object invokeMethod(Object object, String methodName, Object... args) {
    try {
      Class[] types = new Class[args.length];
      for (int i = 0; i < args.length; i++) {
        types[i] = args[i].getClass();
      }
      Method method = object.getClass().getMethod(methodName, types);
      return method.invoke(object, args);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}