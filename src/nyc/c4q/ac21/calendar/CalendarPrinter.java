package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;

public class CalendarPrinter {

    /**
     * Prints a calendar for a month.
     * <p/>
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     * <p/>
     * For example, for 2015-04-03, prints this:
     * <p/>
     * April 2015
     * 1   2   3*  4
     * 5   6   7   8   9  10  11
     * 12  13  14  15  16  17  18
     * 19  20  21  22  23  24  25
     * 26  27  28  29  30
     *
     * @param date The date containing the month to print.
     */
    public static void printMonthCalendar(Calendar date) {
        int month = date.get(Calendar.MONTH);
        String monthStr = DateTools.getMonthNames().get(month);
        int year = date.get(Calendar.YEAR);
        System.out.println("\n" + monthStr + " " + year + "\n");

        int today = date.get(Calendar.DAY_OF_MONTH);
        Calendar newCal = Calendar.getInstance();

        newCal.set(year, month, 1);  //stores their date. 1st day of said month

        int dayOfWeekThatMonthStartsOn = newCal.get(Calendar.DAY_OF_WEEK); //What day of the week is day 1?

        int endofMonth = newCal.getActualMaximum(Calendar.DAY_OF_MONTH); //Length of specified month.

        System.out.println("first day of this month is " + dayOfWeekThatMonthStartsOn);
        System.out.println("last day of month is " + endofMonth + "\n");

        String space = " ";
        //Handles the amount of space for the days that are before the first day of the month.
        //Example: If the first day of the month is on a wednesday, it will print spaces for sunday,monday,tuesday
        for (int x = 1; x < dayOfWeekThatMonthStartsOn; x++) {
            System.out.print("   ");
        }

        //Loop to print the days of the month
        for (int i = 1; i <= endofMonth; i++) {
            //If the number is less than 10, print a blank space, the next if/else statement will handle printing a number

            if (i < 10) {
                System.out.print(space);
            }

            //if the current day minus the day the month starts on is divisible by 7, go to next line
            if (((i - 1) + dayOfWeekThatMonthStartsOn) % 7 == 0) {
                System.out.print(i + "\n");
            } else {
                //Handles printing the star if the number that is currently being printed is the today
                if (i == today) {
                    System.out.print(i + "*");
                } else {
                    System.out.print(i + space);
                }
            }

        }


    }


}
