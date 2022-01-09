package com.vahider.timez;

import com.vahider.timez.enums.DateType;
import com.vahider.timez.enums.WeekType;

//https://docs.oracle.com/cd/E41183_01/DR/Date_Format_Types.html
//https://en.wikipedia.org/wiki/Date_format_by_country

/**
 * Orders:
 * - Timez.
 * - Timez.
 * - Clocz.
 * - Base.
 * .
 * Models:
 * - ATime
 * - AClock
 * .
 * .
 * 1970-01-01T00:00:01+00:00 in ISO 8601
 * Thu, 01 Jan 1970 00:00:01 +0000 in RFC 822, 1036, 1123, 2822
 * Thursday, 01-Jan-70 00:00:01 UTC in RFC 2822
 * 1970-01-01T00:00:01+00:00 in RFC 3339
 * .
 * .
 * This alguritm for Qmari equals with https://www.taghvim.com/
 * For get correct time, must be used from time on the 00:00.00 oclock
 * "yyyy-MM-dd HH:mm:ss"
 * <p>
 * استاتیک تعریف می کنیم چون اکثر لایبرری ها استاتیکن
 */
public class Timez {

    public static final String SPLIT_SPACE = " ", SPLIT_DATE = "-", SPLIT_CLOCK = ":";
    public static final long BASE_NOW = 0;

    static DateType dateType = DateType.MILADI;
    static DateType defaultDateType = DateType.MILADI;
    static String defaultDateFormat = "yyyy" + SPLIT_DATE + "MM" + SPLIT_DATE + "dd";
    static String defaultClockFormat = "HH" + SPLIT_CLOCK + "mm" + SPLIT_CLOCK + "ss";
    //  private static int hourType = 0; // maybe not used, can use with format
    //  private static int local = 0;
    //  private static int type = 0; // Unix stamp, ISO 8601

    private Timez(final Builder builder) {
        dateType = builder.dateType;
        defaultDateType = builder.dateType;
        defaultDateFormat = builder.defaultDateFormat;
        defaultClockFormat = builder.defaultClockFormat;

        Base.setBaseTime(builder.baseTimeStamp);
    }

    // region Biulder
    public static class Builder {

        private DateType dateType = Timez.dateType;
        private long baseTimeStamp = BASE_NOW;
        private String defaultDateFormat = Timez.defaultDateFormat;
        private String defaultClockFormat = Timez.defaultClockFormat;

        public Builder setDateType(final DateType dateType) {
            this.dateType = dateType;
            return this;
        }

        public Builder setBaseTime(final long baseTimeStamp) {
            this.baseTimeStamp = baseTimeStamp;
            return this;
        }

        public Builder setDefaultDateFormat(final String defaultDateFormat) {
            this.defaultDateFormat = defaultDateFormat;
            return this;
        }

        public Builder setDefaultClockFormat(final String defaultClockFormat) {
            this.defaultClockFormat = defaultClockFormat;
            return this;
        }

        public Timez reload() {
            return new Timez(this);
        }
    }
    // endregion

    // region Time
    public static long getStamp() {
        return Engine.getStamp();
    }

    public static ATime getTime() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.getTime();
    }

    public static ATime getTime(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.cache.getTime();
    }

    public static String get(String format) {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.changeFormat(format);
    }

    public static String get(String format, long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.changeFormat(format);
    }

    // Date
    public static String getDate() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.getTime().getDate();
    }

    public static String getDate(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return Engine.cache.getTime().getDate();
    }

    public static String getDate(int year, int month, int day) {
//    Engine.convertD2S(new ATime(year, month, day));
//    Engine.calculateDate(Util.checkStamp(Engine.cache.stamp));
        Engine.cache.year = year;
        Engine.cache.month = month;
        Engine.cache.day = day;
        return Engine.cache.getTime().getDate();
    }

    // Clock
    public static String getClock() {
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.getTime().getClock();
    }

    public static String getClock(long stamp) {
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.cache.getTime().getClock();
    }

    public static String getClock(int hour, int min, int sec) {
//    Engine.convertC2S(new AClock(hour, min, sec));
//    Engine.calculateClock(Util.checkStamp(Engine.cache.stamp));
        Engine.cache.hour = hour;
        Engine.cache.min = min;
        Engine.cache.sec = sec;
        return Engine.cache.getTime().getClock();
    }
    // endregion

    // region Date
    public static int getYear() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.year;
    }

    public static int getYear(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return Engine.cache.year;
    }

    public static String getMonthName() {
        Engine.calculateMonthName(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.monthName;
    }

    public static String getMonthName(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return Engine.cache.monthName;
    }

    public static String getMonthName(int month) {
        Engine.getMonthName(month);
        return Engine.cache.monthName;
    }

    public static int getMonth() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.month;
    }

    public static int getMonth(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return Engine.cache.month;
    }

    public static String getWeekFull() {
        Engine.calculateWeek(WeekType.FULL, Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.weekName;
    }

    public static String getWeekFull(long stamp) {
        Engine.calculateWeek(WeekType.FULL, Util.checkStamp(stamp));
        return Engine.cache.weekName;
    }

    public static String getWeekFull(int week) {
        Engine.getWeek(WeekType.FULL, week);
        return Engine.cache.weekName;
    }

    public static String getWeekShort() {
        Engine.calculateWeek(WeekType.SHORT, Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.weekName;
    }

    public static String getWeekShort(long stamp) {
        Engine.calculateWeek(WeekType.SHORT, Util.checkStamp(stamp));
        return Engine.cache.weekName;
    }

    public static String getWeekShort(int week) {
        Engine.getWeek(WeekType.SHORT, week);
        return Engine.cache.weekName;
    }

    public static int getWeek() {
        Engine.calculateWeek(WeekType.NUMBER, Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.week;
    }

    public static int getWeek(long stamp) {
        Engine.calculateWeek(WeekType.NUMBER, Util.checkStamp(stamp));
        return Engine.cache.week;
    }

    public static int getDay() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.day;
    }

    public static int getDay(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return Engine.cache.day;
    }

    public static int daysOfMonth() {
        Engine.calculateDate(Util.checkStamp(Engine.NOW_TIME));
        return daysOfMonth(Engine.cache.month);
    }

    public static int daysOfMonth(long stamp) {
        Engine.calculateDate(Util.checkStamp(stamp));
        return daysOfMonth(Engine.cache.month);
    }

    public static int daysOfMonth(int month) {
        return Engine.daysOfMonth(month);
    }
    // endregion

    // region Clock
    public static int getHour() {
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.hour;
    }

    public static int getHour(long stamp) {
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.cache.hour;
    }

    public static int getMin() {
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.min;
    }

    public static int getMin(long stamp) {
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.cache.min;
    }

    public static int getSec() {
        Engine.calculateClock(Util.checkStamp(Engine.NOW_TIME));
        return Engine.cache.sec;
    }

    public static int getSec(long stamp) {
        Engine.calculateClock(Util.checkStamp(stamp));
        return Engine.cache.sec;
    }
    // endregion

    // region Converts
    // Date
    public static long convertD2S(ATime date) {
        Engine.convertD2S(date);
        return Engine.cache.stamp;
    }

    public static ATime convertS2D(long sec) {
        Engine.convertS2D(sec);
        return Engine.cache.getTime();
    }

    public static ATime convertDate(ATime date, DateType from, DateType to) {
        Engine.convertDate(date, from, to);
        return Engine.cache.getTime();
    }

    // Clock
    public static ATime convertS2C(long sec) {
        Engine.convertS2C(sec);
        return Engine.cache.getTime();
    }

    public static long convertC2S(ATime clock) {
        Engine.convertC2S(clock);
        return Engine.cache.stamp;
    }
    // endregion

    // region Gregorian
    public static class M {

        private static DateType newDateType = DateType.MILADI;

        // Time
        public static ATime getTime() {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime();
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static ATime getTime(long stamp) {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime(stamp);
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static String get(String format) {
            Timez.dateType = newDateType;
            String result = Timez.get(format);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String get(String format, long stamp) {
            Timez.dateType = newDateType;
            String result = Timez.get(format, stamp);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String getDate() {
            Timez.dateType = newDateType;
            Timez.getDate();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDate(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(int year, int month, int day) {
            Timez.dateType = newDateType;
            Timez.getDate(year, month, day);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getClock() {
            Timez.dateType = newDateType;
            Timez.getClock();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static String getClock(long stamp) {
            Timez.dateType = newDateType;
            Timez.getClock(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static ATime getClock(int hour, int min, int sec) {
            Timez.dateType = newDateType;
            Timez.getClock(hour, min, sec);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime();
        }

        // Date
        public static int getYear() {
            Timez.dateType = newDateType;
            Timez.getYear();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static int getYear(long stamp) {
            Timez.dateType = newDateType;
            Timez.getYear(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static String getMonthName() {
            Timez.dateType = newDateType;
            Timez.getMonthName();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonthName(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(int month) {
            Timez.dateType = newDateType;
            if (month > 12)
                Engine.calculateDate(month);
            else
                Timez.getMonthName(month);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static int getMonth() {
            Timez.dateType = newDateType;
            Timez.getMonth();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static int getMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonth(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static String getWeekFull() {
            Timez.dateType = newDateType;
            Timez.getWeekFull();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort() {
            Timez.dateType = newDateType;
            Timez.getWeekShort();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static int getWeek() {
            Timez.dateType = newDateType;
            Timez.getWeek();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getWeek(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeek(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getDay() {
            Timez.dateType = newDateType;
            Timez.getDay();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int getDay(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDay(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int daysOfMonth() {
            Timez.dateType = newDateType;
            Timez.daysOfMonth();
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.daysOfMonth(stamp);
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(int month) {
            Timez.dateType = newDateType;
            int result = Timez.daysOfMonth(month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        // Clock
        public static int getHour() {
            Timez.dateType = newDateType;
            Timez.getHour();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getHour(long stamp) {
            Timez.dateType = newDateType;
            Timez.getHour(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getMin() {
            Timez.dateType = newDateType;
            Timez.getMin();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getMin(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMin(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getSec() {
            Timez.dateType = newDateType;
            Timez.getSec();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }

        public static int getSec(long stamp) {
            Timez.dateType = newDateType;
            Timez.getSec(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }
    }
    // endregion

    // region Jalali
    public static class J {

        private static DateType newDateType = DateType.JALALI;

        // Time
        public static ATime getTime() {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime();
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static ATime getTime(long stamp) {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime(stamp);
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static String get(String format) {
            Timez.dateType = newDateType;
            String result = Timez.get(format);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String get(String format, long stamp) {
            Timez.dateType = newDateType;
            String result = Timez.get(format, stamp);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String getDate() {
            Timez.dateType = newDateType;
            Timez.getDate();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDate(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(int year, int month, int day) {
            Timez.dateType = newDateType;
            Timez.getDate(year, month, day);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getClock() {
            Timez.dateType = newDateType;
            Timez.getClock();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static String getClock(long stamp) {
            Timez.dateType = newDateType;
            Timez.getClock(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static String getClock(int hour, int min, int sec) {
            Timez.dateType = newDateType;
            Timez.getClock(hour, min, sec);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        // Date
        public static int getYear() {
            Timez.dateType = newDateType;
            Timez.getYear();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static int getYear(long stamp) {
            Timez.dateType = newDateType;
            Timez.getYear(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static String getMonthName() {
            Timez.dateType = newDateType;
            Timez.getMonthName();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonthName(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(int month) {
            Timez.dateType = newDateType;
            if (month > 12)
                Engine.calculateDate(month);
            else
                Timez.getMonthName(month);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static int getMonth() {
            Timez.dateType = newDateType;
            Timez.getMonth();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static int getMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonth(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static String getWeekFull() {
            Timez.dateType = newDateType;
            Timez.getWeekFull();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort() {
            Timez.dateType = newDateType;
            Timez.getWeekShort();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static int getWeek() {
            Timez.dateType = newDateType;
            Timez.getWeek();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getWeek(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeek(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getDay() {
            Timez.dateType = newDateType;
            Timez.getDay();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int getDay(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDay(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int daysOfMonth() {
            Timez.dateType = newDateType;
            Timez.daysOfMonth();
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.daysOfMonth(stamp);
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(int month) {
            Timez.dateType = newDateType;
            int result = Timez.daysOfMonth(month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        // Clock
        public static int getHour() {
            Timez.dateType = newDateType;
            Timez.getHour();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getHour(long stamp) {
            Timez.dateType = newDateType;
            Timez.getHour(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getMin() {
            Timez.dateType = newDateType;
            Timez.getMin();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getMin(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMin(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getSec() {
            Timez.dateType = newDateType;
            Timez.getSec();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }

        public static int getSec(long stamp) {
            Timez.dateType = newDateType;
            Timez.getSec(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }

    }
    // endregion

    // region Qamari
    public static class Q {

        private static DateType newDateType = DateType.QAMARY;

        // Time
        public static ATime getTime() {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime();
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static ATime getTime(long stamp) {
            Timez.dateType = newDateType;
            ATime aTime = Timez.getTime(stamp);
            Timez.dateType = Timez.defaultDateType;
            return aTime;
        }

        public static String get(String format) {
            Timez.dateType = newDateType;
            String result = Timez.get(format);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String get(String format, long stamp) {
            Timez.dateType = newDateType;
            String result = Timez.get(format, stamp);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static String getDate() {
            Timez.dateType = newDateType;
            Timez.getDate();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDate(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getDate(int year, int month, int day) {
            Timez.dateType = newDateType;
            Timez.getDate(year, month, day);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getDate();
        }

        public static String getClock() {
            Timez.dateType = newDateType;
            Timez.getClock();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static String getClock(long stamp) {
            Timez.dateType = newDateType;
            Timez.getClock(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        public static String getClock(int hour, int min, int sec) {
            Timez.dateType = newDateType;
            Timez.getClock(hour, min, sec);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.getTime().getClock();
        }

        // Date
        public static int getYear() {
            Timez.dateType = newDateType;
            Timez.getYear();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static int getYear(long stamp) {
            Timez.dateType = newDateType;
            Timez.getYear(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.year;
        }

        public static String getMonthName() {
            Timez.dateType = newDateType;
            Timez.getMonthName();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonthName(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static String getMonthName(int month) {
            Timez.dateType = newDateType;
            if (month > 12)
                Engine.calculateDate(month);
            else
                Timez.getMonthName(month);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.monthName;
        }

        public static int getMonth() {
            Timez.dateType = newDateType;
            Timez.getMonth();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static int getMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMonth(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.month;
        }

        public static String getWeekFull() {
            Timez.dateType = newDateType;
            Timez.getWeekFull();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekFull(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekFull(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort() {
            Timez.dateType = newDateType;
            Timez.getWeekShort();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static String getWeekShort(int week) {
            Timez.dateType = newDateType;
            Timez.getWeekShort(week);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.weekName;
        }

        public static int getWeek() {
            Timez.dateType = newDateType;
            Timez.getWeek();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getWeek(long stamp) {
            Timez.dateType = newDateType;
            Timez.getWeek(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.week;
        }

        public static int getDay() {
            Timez.dateType = newDateType;
            Timez.getDay();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int getDay(long stamp) {
            Timez.dateType = newDateType;
            Timez.getDay(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.day;
        }

        public static int daysOfMonth() {
            Timez.dateType = newDateType;
            Timez.daysOfMonth();
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(long stamp) {
            Timez.dateType = newDateType;
            Timez.daysOfMonth(stamp);
            int result = daysOfMonth(Engine.cache.month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        public static int daysOfMonth(int month) {
            Timez.dateType = newDateType;
            int result = Timez.daysOfMonth(month);
            Timez.dateType = Timez.defaultDateType;
            return result;
        }

        // Clock
        public static int getHour() {
            Timez.dateType = newDateType;
            Timez.getHour();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getHour(long stamp) {
            Timez.dateType = newDateType;
            Timez.getHour(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.hour;
        }

        public static int getMin() {
            Timez.dateType = newDateType;
            Timez.getMin();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getMin(long stamp) {
            Timez.dateType = newDateType;
            Timez.getMin(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.min;
        }

        public static int getSec() {
            Timez.dateType = newDateType;
            Timez.getSec();
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }

        public static int getSec(long stamp) {
            Timez.dateType = newDateType;
            Timez.getSec(stamp);
            Timez.dateType = Timez.defaultDateType;
            return Engine.cache.sec;
        }
    }
    // endregion
}