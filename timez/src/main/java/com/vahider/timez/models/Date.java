package com.vahider.timez.models;

import com.vahider.timez.Datez;
import com.vahider.timez.Timez;

public class Date {

  public Integer year;
  public String monthName;
  public Integer month;
  public String weekname;
  public Integer week;
  public Integer day;

  public Date() {
  }

  public Date(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public Date getDate() {
    return this;
  }

  public long getStamp() {
    if (year != null && month != null && day != null)
      return Datez.convertD2S(this);
    else
      throw new Error("Details of the date are empty");
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getMonthName() {
    return monthName;
  }

  public void setMonthName(String monthName) {
    this.monthName = monthName;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public String getWeekname() {
    return weekname;
  }

  public void setWeekname(String weekname) {
    this.weekname = weekname;
  }

  public int getWeek() {
    return week;
  }

  public void setWeek(int week) {
    this.week = week;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public String toString() {
    return year + Timez.SPLIT_DATE + month + Timez.SPLIT_DATE + day;
  }
}
