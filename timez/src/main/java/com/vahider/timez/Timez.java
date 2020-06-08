package com.vahider.timez;

import com.vahider.timez.enums.DateType;

//https://docs.oracle.com/cd/E41183_01/DR/Date_Format_Types.html
//https://en.wikipedia.org/wiki/Date_format_by_country

/**
 * Orders:
 * - Timez.
 * - Datez.
 * - Clocz.
 * - Base.
 * .
 * Models:
 * - ADate
 * - AClock
 * .
 * This alguritm for Qmari equals with https://www.taghvim.com/
 * For get correct time, must be used from time on the 00:00.00 oclock
 * "yyyy-MM-dd HH:mm:ss"
 */
public class Timez {

  public static final String SPLIT = " ";
  public static final long BASE_NOW = -1;

  static DateType dateType = DateType.MILADI;
  static DateType defaultDateType = DateType.MILADI;
  static String defaultDateFormat = "yyyy" + Datez.SPLIT + "MM" + Datez.SPLIT + "dd";
  static String defaultClockFormat = "HH" + Clockz.SPLIT + "mm" + Clockz.SPLIT + "ss";
  //  private static int hourType = 0; // maybe not used
  //  private static int local = 0;
  //  private static int type = 0; // Unix stamp, ISO 8601

  private Timez(final Builder builder) {
    dateType = builder.dateType;
    defaultDateType = builder.dateType;
    defaultDateFormat = builder.defaultDateFormat;
    defaultClockFormat = builder.defaultClockFormat;

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

    private DateType dateType = Timez.dateType;
    private long baseTimeStamp = BASE_NOW;
    private String defaultDateFormat = Timez.defaultDateFormat;
    private String defaultClockFormat = Timez.defaultClockFormat;

    public Builder setDateType(final DateType dateType) {
      this.dateType = dateType;
      return this;
    }

    public Builder setBaseTime(final long baseTimeStamp) {
      this.baseTimeStamp = baseTimeStamp;
      return this;
    }

    public Builder setDefaultDateFormat(final String defaultDateFormat) {
      this.defaultDateFormat = defaultDateFormat;
      return this;
    }

    public Builder setDefaultClockFormat(final String defaultClockFormat) {
      this.defaultClockFormat = defaultClockFormat;
      return this;
    }

    public Timez reload() {
      return new Timez(this);
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
      String result = Timez.getTime(stamp);
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
      String result = Timez.getTime(stamp);
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
      String result = Timez.getTime(stamp);
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
