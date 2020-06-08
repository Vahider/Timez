package com.vahider.timez;

import com.vahider.timez.enums.DateType;

public abstract class Clockz {

  public static final String SPLIT = ":";

  public static AClock getClock() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.cache.getClock();
  }

  public static AClock getClock(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.cache.getClock();
  }

  public static AClock getClock(int hour, int min, int sec) {
//    Engine.convertC2S(new AClock(hour, min, sec));
//    Engine.calculateClock(Util.checkStamp(Engine.cache.stamp));
    Engine.cache.hour = hour;
    Engine.cache.min = min;
    Engine.cache.sec = sec;
    return Engine.cache.getClock();
  }

  // Details
  public static int getHour() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.cache.hour;
  }

  public static int getHour(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.cache.hour;
  }

  public static int getMin() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.cache.min;
  }

  public static int getMin(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.cache.min;
  }

  public static int getSec() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.cache.sec;
  }

  public static int getSec(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.cache.sec;
  }

  // Converts
  public static AClock convertS2C(long sec) {
    Engine.convertS2C(sec);
    return Engine.cache.getClock();
  }

  public static long convertC2S(AClock clock) {
    Engine.convertC2S(clock);
    return Engine.cache.stamp;
  }

  // Other types
  public static class M {

    private static DateType newDateType = DateType.MILADI;

    public static AClock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    public static AClock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }
  }

  public static class J {

    private static DateType newDateType = DateType.JALALI;

    public static AClock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    public static AClock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }
  }

  public static class Q {

    private static DateType newDateType = DateType.QAMARY;

    public static AClock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    public static AClock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.sec;
    }
  }
}

