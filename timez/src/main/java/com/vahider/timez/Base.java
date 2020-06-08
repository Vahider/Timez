package com.vahider.timez;

import com.vahider.timez.enums.DateType;

public abstract class Base {

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
      baseTime = Engine.getStamp();
      diffTime = 0;
    } else {
      baseTime = baseTimeStamp;
      diffTime = Engine.getStamp() - baseTimeStamp;
    }
  }

  public static class M {

    private static DateType newDateType = DateType.MILADI;

    public static ADate getDate() {
      Timez.dateType = newDateType;
      Datez.getDate();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getDate();
    }

    public static ADate getDate(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDate(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.getDate();
    }

    // Details
    public static int getYear() {
      Timez.dateType = newDateType;
      Datez.getYear();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.year;
    }

    public static int getYear(long stamp) {
      Timez.dateType = newDateType;
      Datez.getYear(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.year;
    }

    public static String getMonthName() {
      Timez.dateType = newDateType;
      Datez.getMonthName();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.monthName;
    }

    public static String getMonthName(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonthName(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.monthName;
    }

    public static String getMonthName(int month) {
      Timez.dateType = newDateType;
      Datez.getMonthName(month);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.monthName;
    }

    public static int getMonth() {
      Timez.dateType = newDateType;
      Datez.getMonth();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.month;
    }

    public static int getMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonth(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.month;
    }

    public static String getWeekFull() {
      Timez.dateType = newDateType;
      Datez.getWeekFull();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static String getWeekFull(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static String getWeekFull(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static String getWeekShort() {
      Timez.dateType = newDateType;
      Datez.getWeekShort();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static String getWeekShort(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static String getWeekShort(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.weekName;
    }

    public static int getWeek() {
      Timez.dateType = newDateType;
      Datez.getWeek();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.week;
    }

    public static int getWeek(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeek(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.week;
    }

    public static int getDay() {
      Timez.dateType = newDateType;
      Datez.getDay();
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.day;
    }

    public static int getDay(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDay(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.cache.day;
    }

    public static int daysOfMonth() {
      Timez.dateType = newDateType;
      Datez.daysOfMonth();
      int result = daysOfMonth(Engine.cache.month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static int daysOfMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.daysOfMonth(stamp);
      int result = daysOfMonth(Engine.cache.month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static int daysOfMonth(int month) {
      Timez.dateType = newDateType;
      int result = Datez.daysOfMonth(month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }
  }

}