package com.vahider.timez;

import android.view.View;
import android.widget.TextView;

public abstract class Util {

  /*
   * If was length less of 10 digits, should be set some zero in leftside of number. 0000235074
   */
  static long checkStamp(long stamp) {
    if (stamp == Engine.NOW_TIME) {
      return Timez.getStamp();
    } else {
      String result = String.valueOf(stamp);
      int length = result.length();
      if (length > 10) {
        result = result.substring(0, 10);
        return Long.parseLong(result);
      } else
        return stamp;
    }
  }

  public static int getInt(View view) {
    if (view instanceof TextView) // & button & edittext
      return Integer.parseInt(((TextView) view).getText().toString());
    throw new Error("View is not a TextView");
  }

  public static String twoDigits(int number) {
    return (number < 10 ? "0" : "") + number;
  }

}