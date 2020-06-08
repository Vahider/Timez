package com.vahider.timez;

public class ADate {

  public Integer year;
  public Integer month;
  public Integer day;

//  private ADate() {
//  }

   ADate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  // Getter and setter
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  // Getter
  public String getMonthName() {
    if (month != null)
      return Datez.getMonthName(month);
    else
      throw new Error("Details of the date are empty");
  }

  public String getWeekFull() {
    if (year != null && month != null && day != null)
      return Datez.getWeekFull(Datez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  public String getWeekShort() {
    if (year != null && month != null && day != null)
      return Datez.getWeekShort(Datez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  public int getWeek() {
    if (year != null && month != null && day != null)
      return Datez.getWeek(Datez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  // Other
  public long getStamp() {
    if (year != null && month != null && day != null)
      return Datez.convertD2S(this);
    else
      throw new Error("Details of the date are empty");
  }

  public String toString() {
    return Engine.changeFormat(Timez.defaultDateFormat);
//    return Timez.get(Timez.defaultDateFormat, Datez.convertD2S(this));
  }
}
