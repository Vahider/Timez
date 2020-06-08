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

  public ADate getDate() {
    if (year != null && month != null && day != null)
      return new ADate(year, month, day);
    else
      throw new Error("Details of the date are empty");
  }

  public AClock getClock() {
    if (hour != null && min != null && sec != null)
      return new AClock(hour, min, sec);
    else
      throw new Error("Details of the clock are empty");
  }

}