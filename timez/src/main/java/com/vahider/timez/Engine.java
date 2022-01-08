package com.vahider.timez;

import com.vahider.timez.enums.DateType;
import com.vahider.timez.enums.WeekType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/*
 * Calculate Date and clock with Cache
 */
abstract class Engine {

    public static final int DAY_SEC = 86400;
    static final int NOW_TIME = 0;

    private static int[] monthsJ = new int[]{31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
    private static int[] monthsQ = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    private static int[] monthsM = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] monthsNameJ = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
    private static String[] monthsNameQ = new String[]{"محرم", "صفر", "ربیع الاول", "ربیع الثانی", "جمادی الاولی", "جمادی الثانی", "رجب", "شعبان", "رمضان", "شوال", "ذی القعده", "ذی الحجه"};
    private static String[] monthsNameM = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octobr", "November", "December"};
    static final String[] weeksFullJ = new String[]{"شنبه", "یک شنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه"};
    static final String[] weeksFullQ = new String[]{"السبت", "الأحد", "الاثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة"};
    static final String[] weeksFullM = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    static final String[] weeksShortJ = new String[]{"ش", "یک", "دو", "سه", "چهار", "پنج", "ج"};
    static final String[] weeksShortQ = new String[]{"س", "أح", "اث", "ثل", "رب", "خم", "ج"};
    static final String[] weeksShortM = new String[]{"Sa", "Su", "Mo", "Tu", "We", "Th", "Fr"};

    private static int monthIndex;

    public static Cache cache = new Cache(); // Todo : package

    static long getStamp() {
        return System.currentTimeMillis() / 1000;
    }

    // region Calculate
    static void calculateDate(long stamp) {
        stamp = clearClock(stamp);
        if (Timez.dateType == DateType.JALALI)
            convertS2J(stamp);
        else if (Timez.dateType == DateType.QAMARY)
            convertS2Q(stamp);
        else
            convertS2M(stamp);

        getMonthName(cache.month);
//    Logz.v(cache.year + "-" + cache.month + "-" + cache.day);
    }

    static void calculateClock(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp * 1000);
        cache.hour = calendar.get(Calendar.HOUR_OF_DAY);
        cache.min = calendar.get(Calendar.MINUTE);
        cache.sec = calendar.get(Calendar.SECOND);

//    Logz.v(cache.hour + ":" + cache.min + ":" + cache.sec);
    }

    static void calculateMonthName(long stamp) {
        calculateDate(stamp);
        getMonthName(cache.month);
    }

    static void calculateWeek(WeekType weekType, long stamp) {
        convertS2W(stamp);
        getWeek(weekType, cache.week);
    }

    // Helper
    static void getWeek(WeekType weekType, long stamp) {
        if (Timez.dateType == DateType.JALALI)
            cache.weekName = weekType == WeekType.FULL ? weeksFullJ[cache.week] : weeksShortJ[cache.week];
        else if (Timez.dateType == DateType.QAMARY)
            cache.weekName = weekType == WeekType.FULL ? weeksFullQ[cache.week] : weeksShortQ[cache.week];
        else
            cache.weekName = weekType == WeekType.FULL ? weeksFullM[cache.week] : weeksShortM[cache.week];

    }

    static void getMonthName(int month) {
        if (Timez.dateType == DateType.JALALI)
            cache.monthName = monthsNameJ[month - 1];
        else if (Timez.dateType == DateType.QAMARY)
            cache.monthName = monthsNameQ[month - 1];
        else
            cache.monthName = monthsNameM[month - 1];
    }

    private static long clearClock(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp * 1000);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int day = calendar.get(Calendar.SECOND);
        convertC2S(new ATime(0, 0, 0, hour, min, day));
        return stamp - (cache.stamp);
    }

    static int daysOfMonth(long stamp) {
        calculateDate(stamp);

        if (Timez.dateType == DateType.JALALI) {
            return monthsQ[cache.month - 1];
        } else if (Timez.dateType == DateType.QAMARY) {
            return monthsM[cache.month - 1];
        }
        return monthsM[cache.month - 1];
    }

    static String changeFormat(String outputPattern) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(Timez.defaultDateFormat + Timez.SPLIT_SPACE + Timez.defaultClockFormat, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());

        java.util.Date mDate;
        String str = null;

        try {
            mDate = inputFormat.parse(cache.year + Timez.SPLIT_DATE + cache.month + Timez.SPLIT_DATE + cache.day + Timez.SPLIT_SPACE + cache.hour + Timez.SPLIT_CLOCK + cache.min + Timez.SPLIT_CLOCK + cache.sec);
            str = outputFormat.format(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new Error("Time can't converted to your pattern: " + outputPattern);
        }
        return str;
    }
    // endregion

    // region Convert
    private static void convertS2W(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp * 1000);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                cache.week = 1;
                break;
            case Calendar.MONDAY:
                cache.week = 2;
                break;
            case Calendar.TUESDAY:
                cache.week = 3;
                break;
            case Calendar.WEDNESDAY:
                cache.week = 4;
                break;
            case Calendar.THURSDAY:
                cache.week = 5;
                break;
            case Calendar.FRIDAY:
                cache.week = 6;
                break;
            case Calendar.SATURDAY:
                cache.week = 0;
                break;
        }

        // 0 == پنج شنبه
//        stamp = stamp / DAY_SEC;
//        int result = (int) (stamp % 7); // Should result was 4/5 and use 4, then day +1
//        if (result == 0)
//            cache.week = 5;
//        else if (result == 1)
//            cache.week = 6;
//        else if (result == 2)
//            cache.week = 0;
//        else if (result == 3)
//            cache.week = 1;
//        else if (result == 4)
//            cache.week = 2;
//        else if (result == 5)
//            cache.week = 3;
//        else if (result == 6)
//            cache.week = 4;
    }

    static void convertD2S(ATime date) {
        if (Timez.dateType == DateType.JALALI)
            convertJ2S(date);
        else if (Timez.dateType == DateType.QAMARY) {
            convertQ2S(date);
        } else
            convertM2S(date);
    }

    static void convertS2D(long sec) {
        if (Timez.dateType == DateType.JALALI)
            convertS2J(sec);
        else if (Timez.dateType == DateType.QAMARY)
            convertS2Q(sec);
        else
            convertS2M(sec);
    }

    // چنانچه باقی‌ماندهٔ حاصل تقسیم سال مورد نظر بر عدد ۳۳، یکی از اعداد (۱، ۵، ۹، ۱۳، ۱۷، ۲۲، ۲۶ و ۳۰) باشد،[۲] برای سال‌های اخیر برای سال‌های ۱۳۴۳ تا ۱۴۷۲، آن سال کبیسه است و برای سال‌های بین ۱۲۴۴ تا ۱۳۴۲ به‌جای ۲۲، باقی‌ماندهٔ ۲۱ ملاک خواهد بود.
    private static void convertS2J(long sec) { // 1348/10/11
        cache.day = (int) sec / DAY_SEC;
        cache.day -= 18;
        monthIndex = 10;
        cache.year = 1348;
        while (true) {
            if (cache.day > monthsJ[monthIndex])
                cache.day -= monthsJ[monthIndex];
            else
                break;
            monthIndex++;
            if (monthIndex == 12) {
                if (",1,5,9,13,17,22,26,30,".contains("," + (cache.year % 33) + ","))
                    cache.day -= 1;
                cache.year++;
//        Logz.is(cache.year);
                monthIndex = 0;
            }
        }
        cache.month = monthIndex + 1;
    }

    // 1398/11/2
    // tested with 1348 1349 1359 1399 1499 2000
    private static void convertJ2S(ATime mDate) { // 1348/10/11
        int repDay = 0;
        cache.day = 11;
        cache.month = 10;
        monthIndex = 10 - 1;
        cache.year = 1348;

        if (mDate.getYear() < cache.year || mDate.getYear() == cache.year && mDate.getMonth() < cache.month || mDate.getYear() == cache.year && mDate.getMonth() == cache.month && mDate.getDay() < cache.day)
            throw new Error("Your time less of primary stamp: 1348/10/11");

        while (true) {
            if (cache.year == mDate.getYear() && cache.month == mDate.getMonth()) {
                if (mDate.getDay() > cache.day)
                    repDay += (mDate.getDay() - cache.day);
                else
                    repDay -= (cache.day - mDate.getDay());
                break;
            }
            repDay += monthsJ[monthIndex];
            cache.month++;
            monthIndex++;
            if (cache.month > 12) {
                if (",1,5,9,13,17,22,26,30,".contains("," + (cache.year % 33) + ","))
                    repDay++;
                cache.year++;
                cache.month = 1;
                monthIndex = 0;
            }
        }
        cache.stamp = repDay * 86400;
    }

    // tested 1389 1399 1499
    private static void convertQ2S(ATime mDate) {
        int repDay = 0;
        cache.day = 22;
        cache.month = 10;
        monthIndex = 10 - 1;
        cache.year = 1389;

        if (mDate.getYear() < cache.year || mDate.getYear() == cache.year && mDate.getMonth() < cache.month || mDate.getYear() == cache.year && mDate.getMonth() == cache.month && mDate.getDay() < cache.day)
            throw new Error("Your time less of primary stamp: 1389/10/22");

        while (true) {
            if (cache.year == mDate.getYear() && cache.month == mDate.getMonth()) {
                if (mDate.getDay() > cache.day) {
                    repDay += (mDate.getDay() - cache.day);
                } else {
                    repDay -= (cache.day - mDate.getDay());
                }
                break;
            }
            repDay += monthsQ[monthIndex];
            cache.month++;
            monthIndex++;
            if (cache.month > 12) {
                if (",2,5,7,10,13,16,18,21,24,26,30,".contains("," + (cache.year % 30) + ",")) {
                    repDay++;
                }
                cache.year++;
                cache.month = 1;
                monthIndex = 0;
            }
        }
        cache.stamp = repDay * 86400;
    }

    // چنانچه باقی‌ماندهٔ حاصل تقسیم سال قمری به عدد ۳۰ یکی از اعداد (۲، ۵، ۷، ۱۰، ۱۳، ۱۶، ۱۸، ۲۱، ۲۴، ۲۶ و ۲۹) باشد، سال مذکور کبیسه و طول آن (۳۵۵ روزه) می‌باشد.
    private static void convertS2Q(long s) { // 1389/10/22
        cache.day = (int) s / DAY_SEC;
        cache.day -= 7; // Sometimes -= 8 is correct, Test it
        monthIndex = 10;
        cache.year = 1389;
        while (true) {
            if (cache.day > monthsQ[monthIndex]) {
                cache.day -= monthsQ[monthIndex];
            } else {
                break;
            }
            monthIndex++;
            if (monthIndex == 12) {
//        if (((year - 1387) % 3) == 0) {
                if (",2,5,7,10,13,16,18,21,24,26,30,".contains("," + (cache.year % 30) + ",")) {
                    cache.day -= 1;
                }
                cache.year++;
                monthIndex = 0;
            }
        }
        cache.month = monthIndex + 1;
    }

    private static void convertS2M(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp * 1000);
        cache.year = calendar.get(Calendar.YEAR);
        cache.month = calendar.get(Calendar.MONTH) + 1;
        cache.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    private static void convertM2S(ATime date) { // Date sample 2018-9-16 | Start time stamp : M 1970/1/1 3:30 - J 1948/10/11 3:30
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Timez.defaultDateFormat, Locale.getDefault());
            java.util.Date mDate = simpleDateFormat.parse(date.getYear() + Timez.SPLIT_DATE + date.getMonth() + Timez.SPLIT_DATE + date.getDay());
            cache.stamp = mDate.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Other Convert
    static void convertDate(ATime date, DateType from, DateType to) {
        if (from == DateType.JALALI && to == DateType.QAMARY) {
            convertJ2S(date);
            convertS2Q(cache.stamp);
        } else if (from == DateType.JALALI && to == DateType.MILADI) {
            convertJ2S(date);
            convertS2M(cache.stamp);
        } else if (from == DateType.QAMARY && to == DateType.JALALI) {
            convertQ2S(date);
            convertS2J(cache.stamp);
        } else if (from == DateType.QAMARY && to == DateType.MILADI) {
            convertQ2S(date);
            convertS2M(cache.stamp);
        } else if (from == DateType.MILADI && to == DateType.JALALI) {
            convertM2S(date);
            convertS2J(cache.stamp);
        } else if (from == DateType.MILADI && to == DateType.QAMARY) {
            convertM2S(date);
            convertS2Q(cache.stamp);
        }
    }

//  private static void convertM2Q(Date date) {
//    convertM2S(date);
//    convertS2Q(cache.stamp);
//  }
//
//  private static void convertM2J(Date date) {
//    convertM2S(date);
//    convertS2J(cache.stamp);
//  }
//
//  private static void convertQ2M(Date date) {
//    convertQ2S(date);
//    convertS2M(cache.stamp);
//  }
//
//  private static void convertQ2J(Date date) {
//    convertQ2S(date);
//    convertS2J(cache.stamp);
//  }
//
//  private static void convertJ2Q(Date date) {
//    convertJ2S(date);
//    convertS2Q(cache.stamp);
//  }
//
//  private static void convertJ2M(Date date) {
//    convertJ2S(date);
//    convertS2M(cache.stamp);
//  }

    static void convertS2C(long sec) { // 12600 = 3:30
        // sec -= 12600;
        cache.hour = (int) sec / 3600;
        cache.min = (int) ((sec % 3600) / 60);
        cache.sec = (int) ((sec % 3600) % 60);
    }

    static void convertC2S(ATime clock) { // 12600 = 3:30
        cache.stamp = /*12600 +*/ (clock.hour * 3600) + (clock.min * 60) + clock.sec;
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