package com.vahider.timez;

public class AClock {

  public int hour;
  public int min;
  public int sec;

//  public AClock() {
//  }

  AClock(int hour, int min, int sec) {
    this.hour = hour;
    this.min = min;
    this.sec = sec;
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

  public String toString() {
    return Engine.changeFormat(Timez.defaultClockFormat);
//    return Timez.get(Timez.defaultClockFormat, Clockz.convertC2S(this));
  }
}
