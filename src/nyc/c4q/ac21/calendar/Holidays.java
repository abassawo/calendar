package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Holidays {

    /**
     * Loads holidays from a file.
     *
     * @param holidayType
     *   The type of holiday.  Use "National holiday" for U.S. federal holidays.
     * @return
     *   A map from date to holiday name for holidays.
     */
    public HashMap<Calendar, String> getHolidays(String holidayType) {
        ArrayList<String> lines = FileTools.readLinesFromFile("holidays.csv");
        // Each line is of the form "date,name,type", where "date" is a date
        // in YYYY-MM-DD format, "name" is the holiday name, and "type" is
        // the holiday type.  Include only those lines where "type" matches
        // the 'holidayType' parameter.

        HashMap<Calendar, String> holidays = new HashMap<Calendar, String>();
        for (String line : lines) {
            String[] values = line.split(",");
            String date = values[0];
            String name = values[1];
            String type = values[2];

            if (holidayType.equals(type)) {
                Calendar dateCal = DateTools.parseDate(date);
                //System.out.println(date + " : " + name);
                holidays.put(dateCal, name);
            }
            // Use DateTools.parseDate.
        }
        return holidays;
    }
}
