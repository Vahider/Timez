package com.vahider.timez;

import com.vahider.timez.enums.DateType;
import com.vahider.timez.models.Clock;

public class Clockz {

  public static Clock getClock() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.clock.getClock();
  }

  public static Clock getClock(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.clock.getClock();
  }

  // Details
  public static int getHour() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.clock.hour;
  }

  public static int getHour(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.clock.hour;
  }

  public static int getMin() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.clock.min;
  }

  public static int getMin(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.clock.min;
  }

  public static int getSec() {
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.clock.sec;
  }

  public static int getSec(long stamp) {
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.clock.sec;
  }

  // Converts
  public static Clock convertS2C(long sec) {
    return Engine.convertS2C(sec);
  }

  public static long convertC2S(Clock clock) {
    return Engine.convertC2S(clock);
  }

  // Other types
  public static class M {

    private static DateType newDateType = DateType.MILADI;

    public static Clock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    public static Clock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }
  }

  public static class J {

    private static DateType newDateType = DateType.JALALI;

    public static Clock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    public static Clock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }
  }

  public static class Q {

    private static DateType newDateType = DateType.QAMARY;

    public static Clock getClock() {
      Timez.dateType = newDateType;
      Clockz.getClock();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    public static Clock getClock(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getClock(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.getClock();
    }

    // Details
    public static int getHour() {
      Timez.dateType = newDateType;
      Clockz.getHour();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getHour(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getHour(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.hour;
    }

    public static int getMin() {
      Timez.dateType = newDateType;
      Clockz.getMin();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getMin(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getMin(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.min;
    }

    public static int getSec() {
      Timez.dateType = newDateType;
      Clockz.getSec();
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }

    public static int getSec(long stamp) {
      Timez.dateType = newDateType;
      Clockz.getSec(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.clock.sec;
    }
  }
}

