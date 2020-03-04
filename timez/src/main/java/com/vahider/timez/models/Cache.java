package com.vahider.timez.models;

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

  public Date getDate() {
    if (hour != null && min != null && sec != null)
      return new Date(year, month, day);
    else
      throw new Error("Details of the date are empty");
  }

  public Clock getClock() {
    if (hour != null && min != null && sec != null)
      return new Clock(hour, min, sec);
    else
      throw new Error("Details of the clock are empty");
  }


}
