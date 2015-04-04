package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
public class CalendarPrinter
{
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
    public static void printMonthCalendar(Calendar date)
    {
        // FIXME: Write this.
        // Use these methods to help you:
        //System.out.println(DateTools.getMonthNames());
        //System.out.println(DateTools.getNextDay(date));

        int month = date.get(Calendar.MONTH);
        String monthStr = DateTools.getMonthNames().get(month);
        int year = date.get(Calendar.YEAR);
        System.out.println("\n" + monthStr + " " + year + "\n");

        //int workDay_ = date.get(Calendar.DAY_OF_WEEK);
        //int monthday1 = date.getFirstDayOfWeek();
        int today = date.get(Calendar.DAY_OF_MONTH);
        Calendar newCal =  Calendar.getInstance();
        newCal.set(year, month, 1);

        ArrayList<Integer>cal = new ArrayList<Integer>();

//        HashSet<Integer>sun = new HashSet<Integer>();
//        HashSet<Integer>mon = new HashSet<Integer>();
//        HashSet<Integer>tue = new HashSet<Integer>();
//        HashSet<Integer>wed = new HashSet<Integer>();
//        HashSet<Integer>thur = new HashSet<Integer>();
//        HashSet<Integer>fri = new HashSet<Integer>();
//        HashSet<Integer>sat = new HashSet<Integer>();
//
//        if(today == date.get(Calendar.SUNDAY))
//            sun.add(today);
//        else if(today == date.get(Calendar.MONDAY))
//            mon.add(today);
//        else if(today == date.get(Calendar.TUESDAY))
//        tue.add(today);
//        else if(today == date.get(Calendar.WEDNESDAY))
//         wed.add(today);
//        else if(today == date.get(Calendar.THURSDAY))
//        thur.add(today);
//        else if(today == date.get(Calendar.FRIDAY))
//        fri.add(today);

        int offset = newCal.get(Calendar.DAY_OF_WEEK);
        int endofMonth = newCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int numofDaysinMonth = endofMonth - newCal.getFirstDayOfWeek();

        //int offsetdMonth = newCal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("first day of this month is " + offset);
        System.out.println("last day of month is " + endofMonth);


        //System.out.println(13 % 7);

       // System.out.println(offset); //number of days for week to start. offset of 1 represents sunday
        //2 is Monday. 3 is tue. 4 is wed. 5 is thurs. 6 is fri. sat is sunday
        String offsetSpace = "";
        for (int i = 0; i < offset; i++){
            offsetSpace+= " ";
        }


        //explore modular division. EX: IF Today is a saturday, that is the 6th day of week.
        // 7 mod 6 = 1 meaning there is only space for 1 calendar left after this.2
        int MaxDay = newCal.getActualMaximum(Calendar.DAY_OF_WEEK);
        //System.out.print(offsetSpace + today + " * ");
            for (int i = 1; i <= today; i++) {
                int currentDay = i;
                String calPrint = "  ";
                calPrint += i;

               if (i == 1) {
                   if (offset == 1) {
                       calPrint = "  " + i;
                   } else if (offset == 2) {
                       calPrint = "    " + i;
                   } else if (offset == 3) {
                       calPrint = "     " + i;
                   } else if (offset == 4) {
                       calPrint = "        " + i;
                   } else if (offset == 5) {
                       calPrint = "          " + i;
                   } else if (offset == 5) {
                       calPrint = "             " + i;
                   } else {
                       calPrint = "               " + i;
                   }

               }
                if (i == today){
                    calPrint += "*";
                }
                if ((i > 1) && (i % 7) == 1) {
                    calPrint += "\n";
                }
                System.out.print(calPrint);


            }

//        for (int x = 8 - offset; x <= offset + 7; x++) {
//            String calPrintthirdLine = offsetSpace;
//            calPrintthirdLine += x;
//            System.out.println(calPrintthirdLine);
//        }w
        //}


        //String calPrint = offsetSpace;
//        for (int i = today + 1; i <= date.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
//
//            String calPrint = offsetSpace + i;
//
//        }


       // find beginning of week or month and what day it is
        //System.out.println(date.getMinimalDaysInFirstWeek());
            for(int i = today + 1; i <= date.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
            {
                String calPrint = " ";
                calPrint += i;
                System.out.print(calPrint);
            }

    }

}
