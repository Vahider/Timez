package com.vahider.timez_example;

import android.os.Bundle;

import com.vahider.logz.Logz;
import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Info;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.Time;
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
      .setTag("Timez")
      .setEnable(true)
      .setUsed(true)
      .showInfo(true)
      .setInfoClickable(false)
      .setTimeFormat(Time.CLOCK)
      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE)
      .useSummaryMode(Summary.START)
      .setTitleCase(Case.CAMEL_SPACE)
      .showElapsing(true)
      .useViewDetection(true)
      .reload();

    new Timez.Builder()
      .setDateType(DateType.JALALI)
      .reload();

    Logz.i(Datez.getDay(1554319800)); // 1
    Logz.i(Datez.getDay(1556998200)); // 2
    Logz.i(Datez.getDay(1559676600)); // 3
    Logz.i(Datez.getDay(1562355000)); // 4
    Logz.i(Datez.getDay(1565033400)); // 5
    Logz.i(Datez.getDay(1567711800)); // 6
    Logz.i(Datez.getDay(1570393800)); // 7
    Logz.i(Datez.getDay(1572985800)); // 8
    Logz.i(Datez.getDay(1575577800)); // 9
    Logz.i(Datez.getDay(1578169800)); // 10
    Logz.i(Datez.getDay(1580761800)); // 11
    Logz.i(Datez.getDay(1583353800)); // 12
    Logz.i(Timez.getTime());
    Logz.i(Clockz.getClock());
    Logz.i(Clockz.getClock(1583353801));
//    Logz.i(Datez.M.getDay(1583353800));
    Logz.i(Datez.getDay(1583353800));
    Logz.i(Datez.getMonthName());
    Logz.i(Datez.getMonthName(1));
//    Timez.base.setBaseTime(1500000000);
//    Logz.i(Timez.base.getBaseTime());
//    Logz.i(Timez.base.getDiffTime());
//    Logz.i(Timez.base.getDay());
    Logz.i(Timez.getTime());
    Logz.i(Timez.get("HH?MM:yy"));
//    Logz.i(Timez.dur.month2Sec(3));
//    Logz.i(Timez.dur.sec2Day(Timez.dur.month2Sec(3)));
//    Logz.i(Timez.dur.sec2Time(10));

  }
}
