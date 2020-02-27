package com.vahider.timez;

public class Base {

  private static long baseTime = 0;
  private static long diffTime = 0;

  public static long getBaseTime() {
    return baseTime;
  }

  public static long getDiffTime() {
    return diffTime;
  }

  public static void setBaseTime(long baseTimeStamp) {
    if (baseTimeStamp == Timez.BASE_NOW) {
      baseTime = baseTimeStamp;
      diffTime = Engine.getStamp() - baseTimeStamp;
    }
  }

}
