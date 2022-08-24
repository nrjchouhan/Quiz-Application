/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.pojo;

/**
 *
 * @author HP
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
public class DisplayDateTime {

    public static String getMessage() {
        return message;
    }

    public static void setMessage() {
  GregorianCalendar time = new GregorianCalendar();
  int hour = time.get(Calendar.HOUR_OF_DAY);
  int min = time.get(Calendar.MINUTE);
  int day = time.get(Calendar.DAY_OF_MONTH);
  int month = time.get(Calendar.MONTH) + 1;
  int year = time.get(Calendar.YEAR);
  if (hour < 12){
      message="Good Morning";
  }
  else if (hour < 17 && !(hour == 12))
  {
       message="Good Afternoon";
  }
  else if (hour == 12)
  {
          message="Good Noon";
  }
  else
      message="Good Evening";
  
    }
    private static   String  message;
}
