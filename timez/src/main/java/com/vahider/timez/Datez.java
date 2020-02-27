package com.vahider.timez;

import com.vahider.timez.enums.DateType;
import com.vahider.timez.enums.WeekType;
import com.vahider.timez.models.Date;

public class Datez {

  public static Date getDate() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.getDate();
  }

  public static Date getDate(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return Engine.date.getDate();
  }

  // Details
  public static int getYear() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.year;
  }

  public static int getYear(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return Engine.date.year;
  }

  public static String getMonthName() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.monthName;
  }

  public static String getMonthName(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return Engine.date.monthName;
  }

  public static String getMonthName(int month) {
    Engine.getMonthName(month);
    return Engine.date.monthName;
  }

  public static int getMonth() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.month;
  }

  public static int getMonth(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return Engine.date.month;
  }

  public static String getWeekFull() {
    Engine.calculateWeek(WeekType.FULL, Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.weekname;
  }

  public static String getWeekFull(long stamp) {
    Engine.calculateWeek(WeekType.FULL, Util.checkStamp(stamp));
    return Engine.date.weekname;
  }

  public static String getWeekFull(int week) {
    Engine.getWeek(WeekType.FULL, week);
    return Engine.date.weekname;
  }

  public static String getWeekShort() {
    Engine.calculateWeek(WeekType.SHORT, Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.weekname;
  }

  public static String getWeekShort(long stamp) {
    Engine.calculateWeek(WeekType.SHORT, Util.checkStamp(stamp));
    return Engine.date.weekname;
  }

  public static String getWeekShort(int week) {
    Engine.getWeek(WeekType.SHORT, week);
    return Engine.date.weekname;
  }

  public static int getWeek() {
    Engine.calculateWeek(WeekType.NUMBER, Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.week;
  }

  public static int getWeek(long stamp) {
    Engine.calculateWeek(WeekType.NUMBER, Util.checkStamp(stamp));
    return Engine.date.week;
  }

  public static int getDay() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return Engine.date.day;
  }

  public static int getDay(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return Engine.date.day;
  }

  public static int daysOfMonth() {
    Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
    return daysOfMonth(Engine.date.month);
  }

  public static int daysOfMonth(long stamp) {
    Engine.calculateDate(Util.checkStamp(stamp));
    return daysOfMonth(Engine.date.month);
  }

  public static int daysOfMonth(int month) {
    return Engine.daysOfMonth(month);
  }

  // Converts
  public static long convertD2S(Date date) {
    return Engine.convertD2S(date);
  }

  public static Date convertS2D(long sec) {
    return Engine.convertS2D(sec);
  }

  public static Date convertDate(Date date, DateType from, DateType to) {
    return Engine.convertDate(date, from, to);
  }

  // Other types
  public static class M {

    private static DateType newDateType = DateType.MILADI;

    public static Date getDate() {
      Timez.dateType = newDateType;
      Datez.getDate();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    public static Date getDate(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDate(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    // Details
    public static int getYear() {
      Timez.dateType = newDateType;
      Datez.getYear();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static int getYear(long stamp) {
      Timez.dateType = newDateType;
      Datez.getYear(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static String getMonthName() {
      Timez.dateType = newDateType;
      Datez.getMonthName();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonthName(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(int month) {
      Timez.dateType = newDateType;
      Datez.getMonthName(month);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static int getMonth() {
      Timez.dateType = newDateType;
      Datez.getMonth();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static int getMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonth(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static String getWeekFull() {
      Timez.dateType = newDateType;
      Datez.getWeekFull();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort() {
      Timez.dateType = newDateType;
      Datez.getWeekShort();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static int getWeek() {
      Timez.dateType = newDateType;
      Datez.getWeek();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getWeek(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeek(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getDay() {
      Timez.dateType = newDateType;
      Datez.getDay();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int getDay(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDay(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int daysOfMonth() {
      Timez.dateType = newDateType;
      Datez.daysOfMonth();
      int result = daysOfMonth(Engine.date.month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static int daysOfMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.daysOfMonth(stamp);
      int result = daysOfMonth(Engine.date.month);
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

  public static class J {

    private static DateType newDateType = DateType.JALALI;

    public static Date getDate() {
      Timez.dateType = newDateType;
      Datez.getDate();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    public static Date getDate(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDate(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    // Details
    public static int getYear() {
      Timez.dateType = newDateType;
      Datez.getYear();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static int getYear(long stamp) {
      Timez.dateType = newDateType;
      Datez.getYear(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static String getMonthName() {
      Timez.dateType = newDateType;
      Datez.getMonthName();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonthName(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(int month) {
      Timez.dateType = newDateType;
      Datez.getMonthName(month);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static int getMonth() {
      Timez.dateType = newDateType;
      Datez.getMonth();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static int getMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonth(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static String getWeekFull() {
      Timez.dateType = newDateType;
      Datez.getWeekFull();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort() {
      Timez.dateType = newDateType;
      Datez.getWeekShort();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static int getWeek() {
      Timez.dateType = newDateType;
      Datez.getWeek();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getWeek(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeek(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getDay() {
      Timez.dateType = newDateType;
      Datez.getDay();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int getDay(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDay(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int daysOfMonth() {
      Timez.dateType = newDateType;
      Datez.daysOfMonth();
      int result = daysOfMonth(Engine.date.month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static int daysOfMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.daysOfMonth(stamp);
      int result = daysOfMonth(Engine.date.month);
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

  public static class Q {

    private static DateType newDateType = DateType.QAMARY;

    public static Date getDate() {
      Timez.dateType = newDateType;
      Datez.getDate();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    public static Date getDate(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDate(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.getDate();
    }

    // Details
    public static int getYear() {
      Timez.dateType = newDateType;
      Datez.getYear();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static int getYear(long stamp) {
      Timez.dateType = newDateType;
      Datez.getYear(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.year;
    }

    public static String getMonthName() {
      Timez.dateType = newDateType;
      Datez.getMonthName();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonthName(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static String getMonthName(int month) {
      Timez.dateType = newDateType;
      Datez.getMonthName(month);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.monthName;
    }

    public static int getMonth() {
      Timez.dateType = newDateType;
      Datez.getMonth();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static int getMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.getMonth(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.month;
    }

    public static String getWeekFull() {
      Timez.dateType = newDateType;
      Datez.getWeekFull();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekFull(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekFull(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort() {
      Timez.dateType = newDateType;
      Datez.getWeekShort();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static String getWeekShort(int week) {
      Timez.dateType = newDateType;
      Datez.getWeekShort(week);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.weekname;
    }

    public static int getWeek() {
      Timez.dateType = newDateType;
      Datez.getWeek();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getWeek(long stamp) {
      Timez.dateType = newDateType;
      Datez.getWeek(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.week;
    }

    public static int getDay() {
      Timez.dateType = newDateType;
      Datez.getDay();
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int getDay(long stamp) {
      Timez.dateType = newDateType;
      Datez.getDay(stamp);
      Timez.dateType = Timez.defaultDateType;
      return Engine.date.day;
    }

    public static int daysOfMonth() {
      Timez.dateType = newDateType;
      Datez.daysOfMonth();
      int result = daysOfMonth(Engine.date.month);
      Timez.dateType = Timez.defaultDateType;
      return result;
    }

    public static int daysOfMonth(long stamp) {
      Timez.dateType = newDateType;
      Datez.daysOfMonth(stamp);
      int result = daysOfMonth(Engine.date.month);
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

