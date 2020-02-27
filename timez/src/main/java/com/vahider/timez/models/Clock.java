package com.vahider.timez.models;

import com.vahider.timez.Timez;

public class Clock {

  public int hour;
  public int min;
  public int sec;

  public Clock() {
  }

  public Clock(int hour, int min, int sec) {
    this.hour = hour;
    this.min = min;
    this.sec = sec;
  }

  public Clock getClock() {
    return this;
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
    return hour + Timez.SPLIT_CLOCK + min + Timez.SPLIT_CLOCK + sec;
  }
}
