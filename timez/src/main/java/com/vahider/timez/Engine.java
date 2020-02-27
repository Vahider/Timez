package com.vahider.timez;

import com.vahider.timez.enums.DateType;
import com.vahider.timez.enums.WeekType;
import com.vahider.timez.models.Clock;
import com.vahider.timez.models.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Engine {

  public static final int DAY_SEC = 86400;
  static final int NOW_TIME = 0;

  private static int[] monthsJ = new int[]{31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
  private static int[] monthsQ = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
  private static int[] monthsM = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static String[] monthsNameJ = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
  private static String[] monthsNameQ = new String[]{"محرم", "صفر", "ربیع الاول", "ربیع الثانی", "جمادی الاول", "جمادی الثانی", "رجب", "شعبان", "رمضان", "شوال", "ذی قعده", "ذی حجه"};
  private static String[] monthsNameM = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octobr", "November", "December"};
  static final String[] weeksFullJ = new String[]{"شنبه", "یک شنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه"};
  static final String[] weeksFullQ = new String[]{"السبت", "الأحد", "الاثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة"};
  static final String[] weeksFullM = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
  static final String[] weeksShortJ = new String[]{"ش", "یک", "دو", "سه", "چهار", "پنج", "ج"};
  static final String[] weeksShortQ = new String[]{"س", "أح", "اث", "ثل", "رب", "خم", "ج"};
  static final String[] weeksShortM = new String[]{"Sa", "Su", "Mo", "Tu", "We", "Th", "Fr"};

  private static int monthIndex;

  // new
  static Date date = new Date();
  static Clock clock = new Clock();

  static long getStamp() {
    return System.currentTimeMillis() / 1000;
  }

  // region Calculate
  static void calculateDate(long stamp) {
    stamp = clearClock(stamp);

    if (Timez.dateType == DateType.MILADI) {
      convertS2M(stamp);

    } else if (Timez.dateType == DateType.JALALI) {
      convertS2J(stamp);

    } else if (Timez.dateType == DateType.QAMARY) {
      convertS2Q(stamp);
    }

    getMonthName(date.month);
  }

  static void calculateClock(long stamp) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(stamp * 1000);
    clock.hour = calendar.get(Calendar.HOUR_OF_DAY);
    clock.min = calendar.get(Calendar.MINUTE);
    clock.sec = calendar.get(Calendar.SECOND);
  }

  static void calculateWeek(WeekType weekType, long stamp) {
    convertS2W(stamp);
    getWeek(weekType, date.week);
  }

  // Helper
  static void getWeek(WeekType weekType, long stamp) {
    if (Timez.dateType == DateType.JALALI) {
      date.setWeekname(weekType == WeekType.FULL ? weeksFullJ[date.week] : weeksShortJ[date.week]);

    } else if (Timez.dateType == DateType.QAMARY) {
      date.setWeekname(weekType == WeekType.FULL ? weeksFullQ[date.week] : weeksShortQ[date.week]);

    } else {
      date.setWeekname(weekType == WeekType.FULL ? weeksFullM[date.week] : weeksShortM[date.week]);
    }
  }

  static String getMonthName(int month) {
    if (Timez.dateType == DateType.JALALI) {
      date.setMonthName(monthsNameJ[month - 1]);
      return monthsNameJ[month - 1];

    } else if (Timez.dateType == DateType.QAMARY) {
      date.setMonthName(monthsNameQ[month - 1]);
      return monthsNameQ[month - 1];

    } else {
      date.setMonthName(monthsNameM[month - 1]);
      return monthsNameM[month - 1];
    }
  }

  private static long clearClock(long stamp) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(stamp * 1000);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int min = calendar.get(Calendar.MINUTE);
    int day = calendar.get(Calendar.SECOND);
    return stamp - (convertC2S(new Clock(hour, min, day)));
  }

  static int daysOfMonth(long stamp) {
    calculateDate(stamp);

    if (Timez.dateType == DateType.JALALI) {
      return monthsQ[date.month - 1];
    } else if (Timez.dateType == DateType.QAMARY) {
      return monthsM[date.month - 1];
    }
    return monthsM[date.month - 1];
  }

  static String changeFormat(String outputPattern) {
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
    SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());

    java.util.Date mDate;
    String str = null;

    try {
      mDate = inputFormat.parse(date.year + Timez.SPLIT_DATE + date.month + Timez.SPLIT_DATE + date.day + " " + clock.hour + Timez.SPLIT_CLOCK + clock.min + Timez.SPLIT_CLOCK + clock.sec);
      str = outputFormat.format(mDate);
    } catch (ParseException e) {
      e.printStackTrace();
      throw new Error("Time can't converted to your pattern: " + outputPattern);
    }
    return str;
  }
  // endregion

  // region Convert
  private static void convertS2W(long stamp) { // Beginning from 5
    // 0 == Panjshanbe
    stamp = stamp / DAY_SEC;
    int result = (int) (stamp % 7); // Should result was 4/5 and use 4, then day +1
    if (result == 0)
      date.week = 6;
    else if (result == 1)
      date.week = 0;
    else if (result == 2)
      date.week = 1;
    else if (result == 3)
      date.week = 2;
    else if (result == 4)
      date.week = 3;
    else if (result == 5)
      date.week = 4;
    else if (result == 6)
      date.week = 5;
  }

  static long convertD2S(Date date) {
    if (Timez.dateType == DateType.JALALI)
      return convertJ2S(date);
    else if (Timez.dateType == DateType.QAMARY)
      return convertQ2S(date);
    else
      return convertM2S(date);
  }

  static Date convertS2D(long sec) {
    if (Timez.dateType == DateType.JALALI)
      return convertS2J(sec);
    else if (Timez.dateType == DateType.QAMARY)
      return convertS2Q(sec);
    else
      return convertS2M(sec);
  }

  // چنانچه باقی‌ماندهٔ حاصل تقسیم سال مورد نظر بر عدد ۳۳، یکی از اعداد (۱، ۵، ۹، ۱۳، ۱۷، ۲۲، ۲۶ و ۳۰) باشد،[۲] برای سال‌های اخیر برای سال‌های ۱۳۴۳ تا ۱۴۷۲، آن سال کبیسه است و برای سال‌های بین ۱۲۴۴ تا ۱۳۴۲ به‌جای ۲۲، باقی‌ماندهٔ ۲۱ ملاک خواهد بود.
  private static Date convertS2J(long sec) { // 1348/10/11
    date.day = (int) sec / DAY_SEC;
    date.day -= 18;
    monthIndex = 10;
    date.year = 1348;
    while (true) {
      if (date.day > monthsJ[monthIndex]) {
        date.day -= monthsJ[monthIndex];
      } else {
        break;
      }
      monthIndex++;
      if (monthIndex == 12) {
        if (",1,5,9,13,17,22,26,30,".contains("," + (date.year % 33) + ",")) {
          date.day -= 1;
        }
        date.year++;
        monthIndex = 0;
      }
    }
    date.month = monthIndex + 1;
    return date.getDate();
  }

  // 1398/11/2
  // tested with 1348 1349 1359 1399 1499 2000
  private static long convertJ2S(Date mDate) { // 1348/10/11
    int repDay = 0;
    date.day = 11;
    date.month = 10;
    monthIndex = 10 - 1;
    date.year = 1348;

    if (mDate.getYear() < date.year || mDate.getYear() == date.year && mDate.getMonth() < date.month || mDate.getYear() == date.year && mDate.getMonth() == date.month && mDate.getDay() < date.day)
      throw new Error("Your time less of primary stamp: 1348/10/11");

    while (true) {
      if (date.year == mDate.getYear() && date.month == mDate.getMonth()) {
        if (mDate.getDay() > date.day) {
          repDay += (mDate.getDay() - date.day);
        } else {
          repDay -= (date.day - mDate.getDay());
        }
        break;
      }
      repDay += monthsJ[monthIndex];
      date.month++;
      monthIndex++;
      if (date.month > 12) {
        if (",1,5,9,13,17,22,26,30,".contains("," + (date.year % 33) + ",")) {
          repDay++;
        }
        date.year++;
        date.month = 1;
        monthIndex = 0;
      }
    }
    return repDay * 86400;
  }

  // tested 1389 1399 1499
  private static long convertQ2S(Date mDate) {

    int repDay = 0;
    date.day = 22;
    date.month = 10;
    monthIndex = 10 - 1;
    date.year = 1389;

    if (mDate.getYear() < date.year || mDate.getYear() == date.year && mDate.getMonth() < date.month || mDate.getYear() == date.year && mDate.getMonth() == date.month && mDate.getDay() < date.day)
      throw new Error("Your time less of primary stamp: 1389/10/22");

    while (true) {
      if (date.year == mDate.getYear() && date.month == mDate.getMonth()) {
        if (mDate.getDay() > date.day) {
          repDay += (mDate.getDay() - date.day);
        } else {
          repDay -= (date.day - mDate.getDay());
        }
        break;
      }
      repDay += monthsQ[monthIndex];
      date.month++;
      monthIndex++;
      if (date.month > 12) {
        if (",2,5,7,10,13,16,18,21,24,26,30,".contains("," + (date.year % 30) + ",")) {
          repDay++;
        }
        date.year++;
        date.month = 1;
        monthIndex = 0;
      }
    }
    return repDay * 86400;
  }

  // چنانچه باقی‌ماندهٔ حاصل تقسیم سال قمری به عدد ۳۰ یکی از اعداد (۲، ۵، ۷، ۱۰، ۱۳، ۱۶، ۱۸، ۲۱، ۲۴، ۲۶ و ۲۹) باشد، سال مذکور کبیسه و طول آن (۳۵۵ روزه) می‌باشد.
  private static Date convertS2Q(long s) { // 1389/10/22
    date.day = (int) s / DAY_SEC;
    date.day -= 8;
    monthIndex = 10;
    date.year = 1389;
    while (true) {
      if (date.day > monthsQ[monthIndex]) {
        date.day -= monthsQ[monthIndex];
      } else {
        break;
      }
      monthIndex++;
      if (monthIndex == 12) {
//        if (((year - 1387) % 3) == 0) {
        if (",2,5,7,10,13,16,18,21,24,26,30,".contains("," + (date.year % 30) + ",")) {
          date.day -= 1;
        }
        date.year++;
        monthIndex = 0;
      }
    }
    date.month = monthIndex + 1;
    return date.getDate();
  }

  private static Date convertS2M(long stamp) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(stamp * 1000);
    date.setYear(calendar.get(Calendar.YEAR));
    date.setMonth(calendar.get(Calendar.MONTH) + 1);
    date.setDay(calendar.get(Calendar.DAY_OF_MONTH));
    return date.getDate();
  }

  private static long convertM2S(Date date) { // Date sample 2018-9-16 | Start time stamp : M 1970/1/1 3:30 - J 1948/10/11 3:30
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
      java.util.Date mDate = simpleDateFormat.parse(date.getDate().toString());
      return mDate.getTime() / 1000;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return 0;
  }

  // Other Convert
  static Date convertDate(Date date, DateType from, DateType to) {
    if (from == DateType.JALALI && to == DateType.QAMARY)
      return convertS2Q(convertJ2S(date));
    else if (from == DateType.JALALI && to == DateType.MILADI)
      return convertS2M(convertJ2S(date));
    else if (from == DateType.QAMARY && to == DateType.JALALI)
      return convertS2J(convertQ2S(date));
    else if (from == DateType.QAMARY && to == DateType.MILADI)
      return convertS2M(convertQ2S(date));
    else if (from == DateType.MILADI && to == DateType.JALALI)
      return convertS2J(convertM2S(date));
    else if (from == DateType.MILADI && to == DateType.QAMARY)
      return convertS2Q(convertM2S(date));
    return date;
  }

  private static Date convertM2Q(Date date) {
    return convertS2Q(convertM2S(date));
  }

  private static Date convertM2J(Date date) {
    return convertS2J(convertM2S(date));
  }

  private static Date convertQ2M(Date date) {
    return convertS2M(convertQ2S(date));
  }

  private static Date convertQ2J(Date date) {
    return convertS2J(convertQ2S(date));
  }

  private static Date convertJ2Q(Date date) {
    return convertS2Q(convertJ2S(date));
  }

  private static Date convertJ2M(Date date) {
    return convertS2M(convertJ2S(date));
  }

  static Clock convertS2C(long sec) {
    clock.hour = (int) sec / 3600;
    clock.min = (int) ((sec % 3600) / 60);
    clock.sec = (int) ((sec % 3600) % 60);
    return clock;
  }

  static long convertC2S(Clock clock) {
    return (clock.hour * 3600) + (clock.min * 60) + clock.sec;
  }
  // endregion

//  public long convertJ2S(int jYear, int jMonth, int jDay) {
//    return getSecondsFrom(convertM2J(jYear, jMonth, jDay));
//  }
//  static void convertS2J(long sec) {
//    date.setDay((int) sec / DAY_SEC); // 16278
//    date.setMonth(10);
//    date.setDay(date.getDay() - 18);
//    date.setYear(1348);
//    while (true) {
//      if (date.getDay() > monthsJ[date.getMonth()]) {
//        date.setDay(date.getDay() - monthsJ[date.getMonth()]);
//      } else {
//        break;
//      }
//      date.setMonth(date.getMonth() + 1);
//      if (date.getMonth() == 12) {
//        if (((date.getYear() - 1347) % 4) == 0) {
//          date.setDay(date.getDay() - 1);
//        }
//        date.setYear(date.getYear() + 1);
//        date.setMonth(0);
//      }
//    }
//  }
//  static void convertSec2J(long sec) {
//    int day = (int) sec / DAY_SEC; // 16278
//    int month = 10;
//    day -= 18;
//    int year = 1348;
//    while (true) {
//      if (day > monthsJ[month]) {
//        day -= monthsJ[month];
//      } else {
//        break;
//      }
//      month++;
//      if (month == 12) {
//        if (((year - 1347) % 4) == 0) {
//          day -= 1;
//        }
//        year++;
//        month = 0;
//      }
//    }
//
//    date.setYear(year);
//    date.setMonth(month);
//    date.setDay(day);
//  }
  // endregion
  /////////////////
//  private void convertTime(long s) {
//    Calendar calendar = Calendar.getInstance();
//    if (s != NOW_TIME)
//      calendar.setTimeInMillis(s * 1000);
//    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
//    this.minute = calendar.get(Calendar.MINUTE);
//    this.second = calendar.get(Calendar.SECOND);
//  }
//
//  private void convertWeek(boolean unixFormat, long s) {
//    Calendar calendar = Calendar.getInstance();
//    if (s != NOW_TIME)
//      calendar.setTimeInMillis(s * 1000);
//    int cYear = calendar.get(Calendar.YEAR);
//    int cMonth = calendar.get(Calendar.MONTH) + 1;
//    int cDay = calendar.get(Calendar.DAY_OF_MONTH);
//    String thisYear = cYear + "-" + cMonth + "-" + cDay;
//    getWeekFromSeconds(getSecondsFrom(unixFormat, thisYear));
//  }
  // Helper method
//  public String getMonthName(int month) {
//    if (dateType == DateType.JALALI) {
//      return monthsNameJ[month - 1];
//    } else if (dateType == DateType.QAMARY) {
//      return monthsNameQ[month - 1];
//    }
//    return monthsNameM[month - 1];
//  }

}