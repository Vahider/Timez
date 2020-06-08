package com.vahider.timez_example;

import android.os.Bundle;

import com.vahider.logz.Logz;
import com.vahider.timez.Base;
import com.vahider.timez.Clockz;
import com.vahider.timez.Datez;
import com.vahider.timez.Timez;
import com.vahider.timez.enums.DateType;

import androidx.appcompat.app.AppCompatActivity;

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
      .setDateType(DateType.JALALI)  /*✓*/
      .reload();

//    Logz.i(Clockz.getClock(10, 0, 0));
//    long s = Clockz.convertC2S(Clockz.getClock(10, 0, 0));
//    Logz.i(s);
//    Logz.i(Clockz.convertS2C(s));

//    Logz.i(Engine.cache.day);
//    Logz.i(Timez.getTime());
//    Logz.i(Engine.cache.day);


//    Logz.i(Util.checkStamp(12345678900L));

    Logz.i(Timez.getStamp()); /*✓*/

    Logz.line("میلادی");
    Logz.i(Timez.M.getTime()); /*✓*/
    Logz.i(Datez.M.getDate()); /*✓*/
    Logz.i(Clockz.M.getClock()); /*✓*/
    Logz.i(Datez.M.getMonthName()); /*✓*/

    Logz.line("شمسی");
    Logz.i(Timez.J.getTime()); /*✓*/
    Logz.i(Datez.J.getDate()); /*✓*/
    Logz.i(Clockz.J.getClock()); /*✓*/
    Logz.i(Datez.J.getMonthName()); /*✓*/

    Logz.line("قمری");
    Logz.i(Timez.Q.getTime()); /*✓*/
    Logz.i(Datez.Q.getDate()); /*✓*/
    Logz.i(Clockz.Q.getClock()); /*✓*/
    Logz.i(Datez.Q.getMonthName()); /*✓*/

    Logz.line();

    Logz.i("1-15", Datez.getDay(1554319800)); /*✓*/
    Logz.i("2-15", Datez.getDay(1556998200)); /*✓*/
    Logz.i("3-15", Datez.getDay(1559676600)); /*✓*/
    Logz.i("4-15", Datez.getDay(1562355000)); /*✓*/
    Logz.i("5-15", Datez.getDay(1565033400)); /*✓*/
    Logz.i("6-15", Datez.getDay(1567711800)); /*✓*/
    Logz.i("7-15", Datez.getDay(1570393800)); /*✓*/
    Logz.i("8-15", Datez.getDay(1572985800)); /*✓*/
    Logz.i("9-15", Datez.getDay(1575577800)); /*✓*/
    Logz.i("10-15", Datez.getDay(1578169800)); /*✓*/
    Logz.i("11-15", Datez.getDay(1580761800)); /*✓*/
    Logz.i("12-15", Datez.getDay(1583353800)); /*✓*/

    Logz.line(1583353799);
    Logz.i(Timez.M.getTime(1583353799));
    Logz.i(Datez.M.getMonthName(3));
    Logz.i(Timez.J.getTime(1583353799));
    Logz.i(Datez.J.getMonthName(12));
    Logz.i(Timez.Q.getTime(1583353799));
    Logz.i(Datez.Q.getMonthName(7));

    Logz.line(1583353801);
    Logz.i(Timez.M.getTime(1583353801));
    Logz.i(Datez.M.getMonthName(3));
    Logz.i(Timez.J.getTime(1583353801));
    Logz.i(Datez.J.getMonthName(12));
    Logz.i(Timez.Q.getTime(1583353801));
    Logz.i(Datez.Q.getMonthName(7));

    Logz.line("Base time");

    Base.setBaseTime(1591673743);
    Logz.i(Base.getDiffTime());
    Logz.i("Now Time",Timez.getTime(1591587343));

//    Logz.i(Datez.getMonthName());
//    Logz.i(Datez.getMonthName(1));
//    Timez.base.setBaseTime(1500000000);
//    Logz.i(Timez.base.getBaseTime());
//    Logz.i(Timez.base.getDiffTime());
//    Logz.i(Timez.base.getDay());
//    Logz.i(Timez.get("HH?MM:yy"));
//    Logz.i(Timez.dur.month2Sec(3));
//    Logz.i(Timez.dur.sec2Day(Timez.dur.month2Sec(3)));
//    Logz.i(Timez.dur.sec2Time(10));

  }
}
