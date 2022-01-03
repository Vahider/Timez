package com.vahider.timez;

public class Cache {

  public Integer year;
  public Integer month;
  public Integer day;

  public int week;
  public String monthName;
  public String weekName;

  public Integer hour;
  public Integer min;
  public Integer sec;

  public long stamp;

  public ATime getTime() {
//    if (year != null && month != null && day != null)
      return new ATime(year, month, day, hour, min, sec);
//    else
//      throw new Error("Details of the time are empty");
  }

//  public String getDate() {
//    if (year != null && month != null && day != null)
//      return Engine.changeFormat(Timez.defaultDateFormat);
//    else
//      throw new Error("Details of the date are empty");
//  }
//
//  public String getClock() {
//    if (hour != null && min != null && sec != null)
//      return Engine.changeFormat(Timez.defaultClockFormat);
//    else
//      throw new Error("Details of the clock are empty");
//  }

}