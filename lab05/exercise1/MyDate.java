package lab05.exercise1;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;

// import javax.swing.text.DateFormatter;

import java.text.SimpleDateFormat;
// import java.util.Calendar;

public class MyDate {
    
    static String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        String date = dateFormat.format(new Date());
        return date;
    }

    static int calculateDaysBtwDates(String day1, String day2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        long miliseconds=0;

        Date d1 = dateFormat.parse(day1);
        Date d2 = dateFormat.parse(day2);
        miliseconds = d2.getTime() - d1.getTime();

        int days = (int) (miliseconds / (1000 * 60 * 60 * 24)) - 1; 
        // -1 to exclude the date itself

        return days;
    }

    static String findDay(String d) throws ParseException {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dayFormat.parse(d);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayOfWeekISO = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        if (dayOfWeekISO == 0){
            dayOfWeekISO += 1;
        }

        String[] days = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        return days[dayOfWeekISO];
    }
}
