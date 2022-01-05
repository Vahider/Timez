package com.vahider.timez;

public class ATime {

  public static final int TODAY = -1;

  public Integer year;
  public Integer month;
  public Integer day;
  public int hour;
  public int min;
  public int sec;

  public ATime() {
    this.year = Timez.getYear();
    this.month = Timez.getMonth();
    this.day = Timez.getDay();
    this.hour = Timez.getHour();
    this.min = Timez.getMin();
    this.sec = Timez.getSec();
  }

  public ATime(int year, int month, int day, int hour, int min, int sec) {
    this.year = year == TODAY ? Timez.getYear() : year;
    this.month = month == TODAY ? Timez.getMonth() : month;
    this.day = day == TODAY ? Timez.getDay() : day;
    this.hour = hour == TODAY ? Timez.getHour() : hour;
    this.min = min == TODAY ? Timez.getMin() : min;
    this.sec = sec == TODAY ? Timez.getSec() : sec;
  }

  public String getDate() {
    return Engine.changeFormat(Timez.defaultDateFormat);
  }

  public String getClock() {
    return Engine.changeFormat(Timez.defaultClockFormat);
  }

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

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getSec() {
    return sec;
  }

  public void setSec(int sec) {
    this.sec = sec;
  }

  // Getter
  public String getMonthName() {
    if (month != null)
      return Timez.getMonthName(month);
    else
      throw new Error("Details of the date are empty");
  }

  public String getWeekFull() {
    if (year != null && month != null && day != null)
      return Timez.getWeekFull(Timez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  public String getWeekShort() {
    if (year != null && month != null && day != null)
      return Timez.getWeekShort(Timez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  public int getWeek() {
    if (year != null && month != null && day != null)
      return Timez.getWeek(Timez.convertD2S(this));
    else
      throw new Error("Details of the date are empty");
  }

  // Other
  public long getStamp() {
    if (year != null && month != null && day != null)
      return Timez.convertD2S(this);
    else
      throw new Error("Details of the date are empty");
  }

  public String toString() {
    return Engine.changeFormat(Timez.defaultDateFormat + Timez.SPLIT_SPACE + Timez.defaultClockFormat);
  }

}
