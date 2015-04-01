package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("date: ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if (date == null)
            return;
        System.out.println();

        System.out.println("date:              " + DateTools.formatDate(date));

        // FIXME: Write the rest of this method!

        // 1. Show the day of the week.

        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

        //System.out.println("Date is " + date.get(Calendar.DATE));
        String dateOfWeek = dayOfWeekNames.get(dayOfWeek);
        //System.out.println("work day: " +isWorkDay);
        //System.out.println("national holiday: " +isHoliday);
        System.out.println("day of week: " + "      " + dateOfWeek); //string

        HashMap<Integer, String> monthNames = DateTools.getMonthNames();
        int month = date.get(Calendar.MONTH);
        String monthStr = monthNames.get(month);
        //System.out.println("Month is " + monthStr );

        // 2. Show whether this is a work day.
        HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        // ...

        // 3. Show whether this is a national holiday, and if so, which.
        //HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        // ...

        // 4. Show whether this date is in DST.
        if (DST.isDST(date)){
          // TODO  System.out.println(DST.getDSTDates(date);
        // ...

        // 5. Show the zodiac sign.

        String zodiacSign = Zodiac.getZodiacSign(date);
        System.out.println("Zodiac sign" + "        "  + zodiacSign);
        //

                // 6. Print out the monthly calendar.
                CalendarPrinter.printMonthCalendar(date);

    }
}
