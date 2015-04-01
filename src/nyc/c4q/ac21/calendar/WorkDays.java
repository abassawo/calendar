package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class WorkDays {

    /**
     * Builds a map from day of week to whether this is a work day.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY', indicating whether each is a work day.
     */
    public static HashMap<Integer, Boolean> getWorkDays() {
        HashMap<Integer,Boolean> workdays  = new HashMap<Integer,Boolean>();
        workdays.put(Calendar.MONDAY,true);
        workdays.put(Calendar.TUESDAY,true);
        workdays.put(Calendar.WEDNESDAY,true);
        workdays.put(Calendar.THURSDAY,true);
        workdays.put(Calendar.FRIDAY,true);
        workdays.put(Calendar.SATURDAY,false);
        workdays.put(Calendar.SUNDAY,false);
        return workdays;  // Change this!
    }
}
