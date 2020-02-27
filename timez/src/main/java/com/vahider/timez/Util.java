package com.vahider.timez;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Util {

  static long checkStamp(long stamp) {
    if (stamp == Engine.NOW_TIME) {
      return Timez.getStamp();
    } else {
      String strStamp = String.valueOf(stamp);
      StringBuilder result = new StringBuilder(strStamp);
      int length = result.length();
      if (length > 10) {
        result.substring(0, length - (length - 10));
        return Long.parseLong(result.toString());
      } else
        return stamp;
    }
  }

  public static int toInt(View view) {
    if (view instanceof TextView || view instanceof EditText || view instanceof Button)
      return Integer.parseInt(((TextView) view).getText().toString());
    throw new Error("View is not a TextView");
  }

  public static int toInt(String number) {
    return Integer.parseInt(number);
  }

}