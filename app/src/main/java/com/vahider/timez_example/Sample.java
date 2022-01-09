package com.vahider.timez_example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vahider.logz.Logz;
import com.vahider.timez.ATime;
import com.vahider.timez.Timez;
import com.vahider.timez.enums.DateType;

//  // now
//  Timez.getDay(stamp);
//  Timez.getDay();
//
//  Timez.M.getDay()
//    Timez.J.getDay()
//    Timez.Q.getDay()
//
//    Timez.base.getDay()
//    Timez.dur.getDay()
//
//    // Convert
//    Timez.ConvertM2J();
//  Timez.ConvertM2Q();
//  Timez.ConvertQ2M();
//  Timez.ConvertQ2J();
//  Timez.ConvertJ2M();
//  Timez.ConvertJ2Q();
//  Timez.Convert2Sec(); // Time Clock Date

public class Sample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        new Logz.Builder()
                .setInfoClickable(true)
                .reload();

        new Timez.Builder()
                .setDateType(DateType.QAMARY)  /*✓*/
                .reload();

//        Logz.i(Timez.convertD2S(new ATime(1389, 10, 22, 0, 0, 0)));

//    Logz.i(Clockz.getClock(10, 0, 0));
//    long s = Clockz.convertC2S(Clockz.getClock(10, 0, 0));
//    Logz.i(s);
//    Logz.i(Clockz.convertS2C(s));

//    Logz.i(Engine.cache.day);
//    Logz.i(Timez.getTime());
//    Logz.i(Engine.cache.day);

//    Logz.i(Util.checkStamp(12345678900L));

//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        Logz.is("1", calendar.getTime().getTime());
//        Logz.is("3", calendar.getTime().getTimezoneOffset());
//        Logz.is("5", calendar.getTimeInMillis());
//        Logz.is("6", calendar.getTimeZone().getDisplayName());
//        Logz.is("7", calendar.getTimeZone().getDSTSavings());
//        Logz.is("8", calendar.getTimeZone().getOffset(Timez.getStamp()));

//        Calendar calendar = Calendar.getInstance();
//        Date date1 = new Date();
////        date1.setDate(45);
//        date1.setMonth(9);
//        date1.setYear(2020);
//        date1.setHours(0);
//        date1.setMinutes(0);
//        date1.setSeconds(0);
//        date1.setSeconds(0);
//
//        Logz.is(date1.getTime());
//        Logz.is(date1.getYear());
//        Logz.is(date1.getMonth());
//        Logz.is(date1.getDate());
//        Logz.is(date1.getDay());
//        Logz.is(date1.getHours());
//        Logz.is(date1.getMinutes());
//        Logz.is(date1.getSeconds());
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date1);
//        Logz.is(cal.getTime().getTime());
//        Logz.is(cal.getTimeInMillis());

//        Logz.i(Timez.getStamp()); /*✓*/
//        Logz.is(TimeZone.getDefault());
////
//        Logz.line("میلادی");
//        Logz.i(Timez.M.getWeek());
//        Logz.i(Timez.M.getWeekFull());
//        Logz.i(Timez.M.getMonthName()); /*✓*/
//        Logz.i(Timez.M.getTime()); /*✓*/
//        Logz.i(Timez.M.getDate()); /*✓*/
//        Logz.i(Timez.M.getClock()); /*✓*/
//        Logz.d("J2M", Timez.convertDate(Timez.J.getTime(), DateType.JALALI, DateType.MILADI).getDate());
//        Logz.e("Q2M-sr", Timez.convertDate(Timez.Q.getTime(), DateType.QAMARY, DateType.MILADI).getDate());
////
//        Logz.line("شمسی");
//        Logz.i(Timez.J.getWeek());
//        Logz.i(Timez.J.getWeekFull());
//        Logz.i(Timez.J.getMonthName()); /*✓*/
//        Logz.i(Timez.J.getTime()); /*✓*/
//        Logz.i(Timez.J.getDate()); /*✓*/
//        Logz.i(Timez.J.getClock()); /*✓*/
//        Logz.d("M2J", Timez.convertDate(Timez.M.getTime(), DateType.MILADI, DateType.JALALI).getDate());
//        Logz.e("Q2J-s", Timez.convertDate(Timez.Q.getTime(), DateType.QAMARY, DateType.JALALI).getDate()); // time eshtebe vali dorost armiad
////
//        Logz.line("قمری");
//        Logz.i(Timez.Q.getWeek());
//        Logz.i(Timez.Q.getWeekFull());
//        Logz.i(Timez.Q.getMonthName()); /*✓*/
//        Logz.i(Timez.Q.getTime()); /*✓*/
//        Logz.i(Timez.Q.getTime()); /*✓*/
//        Logz.i(Timez.Q.getClock()); /*✓*/
//        Logz.d("J2Q", Timez.convertDate(Timez.J.getTime(), DateType.JALALI, DateType.QAMARY).getDate());
//        Logz.d("M2Q", Timez.convertDate(Timez.M.getTime(), DateType.MILADI, DateType.QAMARY).getDate());
//
//        Logz.line();

//    Logz.i("1-15", Timez.getDay(1554319800)); /*✓*/
//    Logz.i("2-15", Timez.getDay(1556998200)); /*✓*/
//    Logz.i("3-15", Timez.getDay(1559676600)); /*✓*/
//    Logz.i("4-15", Timez.getDay(1562355000)); /*✓*/
//    Logz.i("5-15", Timez.getDay(1565033400)); /*✓*/
//    Logz.i("6-15", Timez.getDay(1567711800)); /*✓*/
//    Logz.i("7-15", Timez.getDay(1570393800)); /*✓*/
//    Logz.i("8-15", Timez.getDay(1572985800)); /*✓*/
//    Logz.i("9-15", Timez.getDay(1575577800)); /*✓*/
//    Logz.i("10-15", Timez.getDay(1578169800)); /*✓*/
//    Logz.i("11-15", Timez.getDay(1580761800)); /*✓*/
//    Logz.i("12-15", Timez.getDay(1583353800)); /*✓*/
//
//    Logz.line(1583353799);
//    showDiffrentTime(1583353799);
//
//    Logz.line(1583353801);
//    showDiffrentTime(1583353801);
//    Logz.line();
//
//    Logz.line("100 year ago : -4593515400");
//    showDiffrentTime(-4593515400L);
//
//    Logz.line("60 year ago : -1437841800");
//    showDiffrentTime(-1437841800L);
//
//    Logz.line("30 year ago : 455614200");
//    showDiffrentTime(455614200L);
//
//    Logz.line("10 year ago : 1086766200");
//    showDiffrentTime(1086766200L);
//
//    Logz.line("5 year ago : 1402299000");
//    showDiffrentTime(1402299000L);
//
//    Logz.line("1 year ago : 1560065400");
//    showDiffrentTime(1560065400L);
//
//    Logz.line("Now : 1591687800");
//    showDiffrentTime(1591687800L);
//
//    Logz.line("1 year later : 1623223800");
//    showDiffrentTime(1623223800L);
//
//    Logz.line("5 year later : 1780990200");
//    showDiffrentTime(1780990200L);
//
//    Logz.line("10 year later : 2096609400");
//    showDiffrentTime(2096609400L);
//
//    Logz.line("30 year later : 3043294200");
//    showDiffrentTime(3043294200L);
//
//    Logz.line("60 year later : 4936663800");
//    showDiffrentTime(4936663800L);
//
//    Logz.line("100 year later : 8092337400");
//    showDiffrentTime(8092337400L);
//
//    Logz.line("Base time");
//
//
////    Base.setBaseTime(1591673743);
////    Logz.i(Base.getDiffTime());
////    Logz.i("Now Time",Timez.getTime(1591587343));
////
////      Timez.gregorian().getDay();
////      Timez.M.getDay();
//
////    Logz.i(Datez.getMonthName());
////    Logz.i(Datez.getMonthName(1));
////    Timez.base.setBaseTime(1500000000);
////    Logz.i(Timez.base.getBaseTime());
////    Logz.i(Timez.base.getDiffTime());
////    Logz.i(Timez.base.getDay());
////    Logz.i(Timez.get("HH?MM:yy"));
////    Logz.i(Timez.dur.month2Sec(3));
////    Logz.i(Timez.dur.sec2Day(Timez.dur.month2Sec(3)));
////    Logz.i(Timez.dur.sec2Time(10));

    }

    private void showDiffrentTime(long ts) {
        Logz.i(Timez.M.getTime(ts), Timez.M.getMonthName(ts));
        Logz.i(Timez.J.getTime(ts), Timez.J.getMonthName(ts));
        Logz.i(Timez.Q.getTime(ts), Timez.Q.getMonthName(ts));
    }
}
