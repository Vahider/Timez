package com.vahider.timez;

import com.vahider.timez.enums.DateType;

/**
 * This alguritm for Qmari equals with https://www.taghvim.com/
 * For get correct time, must be used from time on the 00:00.00 oclock
 */
public class Timez {

  public static final String SPLIT = " ";
  public static final long BASE_NOW = -1;

  static DateType dateType = DateType.JALALI;
  static DateType defaultDateType = DateType.JALALI;
  //  private static int clockFormat = 0;
  //  private static int dateFormat = 0;
  //  private static int hourType = 0; // maybe not used
  //  private static int local = 0;
  //  private static int type = 0; // Unix stamp, ISO 8601

  private Timez(final Builder builder) {
    dateType = builder.dateType;
    defaultDateType = builder.dateType;

    Base.setBaseTime(builder.baseTimeStamp);
  }

  // region Getter
  public static long getStamp() {
    return Engine.getStamp();
  }

  public static String getTime() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.cache.getDate() + SPLIT + Engine.cache.getClock();
  }

  public static String getTime(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.cache.getDate() + SPLIT + Engine.cache.getClock();
  }

  public static String get(String format) {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
    return Engine.changeFormat(format);
  }

  public static String get(String format, long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    Engine.calculateClock(Util.checkStamp(stamp));
    return Engine.changeFormat(format);
  }
  // endregion

  // region Biulder
  public static class Builder {

    private DateType dateType = DateType.MILADI;
    private long baseTimeStamp = BASE_NOW;

    public Builder setDateType(final DateType dateType) {
      this.dateType = dateType;
      return this;
    }

    public Builder setBaseTime(final long baseTimeStamp) {
      this.baseTimeStamp = baseTimeStamp;
      return this;
    }

    public Timez reload() {
      return new Timez(this);
      /*
      User user = new User(firstName, lastName, age);
        if (user.firstName.isEmpty()) {
          throw new IllegalStateException("You forgot the name");
        }
      return user;
      */
    }
  }
  // endregion

  // Other types
  public static class M {

    private static DateType newDateType = DateType.MILADI;

    public static String getTime() {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String getTime(long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format) {
      Timez.dateType = newDateType;
      String result = Timez.get(format);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format, long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.get(format, stamp);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }
  }

  public static class J {

    private static DateType newDateType = DateType.JALALI;

    public static String getTime() {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String getTime(long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format) {
      Timez.dateType = newDateType;
      String result = Timez.get(format);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format, long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.get(format, stamp);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }
  }

  public static class Q {

    private static DateType newDateType = DateType.QAMARY;

    public static String getTime() {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String getTime(long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.getTime();
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format) {
      Timez.dateType = newDateType;
      String result = Timez.get(format);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static String get(String format, long stamp) {
      Timez.dateType = newDateType;
      String result = Timez.get(format, stamp);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }
  }
}
