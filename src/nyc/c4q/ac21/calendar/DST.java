package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */
public class DST {

    /**
     * Populates hash maps with the start and end time for DST in each year.
     * @param startDates
     *   A hash map of the start date of DST in each year.
     * @param endDates
     *   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates) {
        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");
        // FIXME: Write this method.
        for (String line : lines) {
            int comma = line.indexOf(',');
            Calendar start = DateTools.parseDate(line.substring(0, comma));
            Calendar end = DateTools.parseDate(line.substring(comma + 1));
            int year = start.get(Calendar.YEAR);
            startDates.put(year, start);
            endDates.put(year, end);
        }
    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     * @param date
     *   The date to check.
     * @return
     *   True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date) {
        // Create hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populate them.
        DST.getDSTDates(dstStartDates, dstEndDates);

        // FIXME: Write this.
        int year = date.get(Calendar.YEAR);
        Calendar dstStart = dstStartDates.get(year);
        Calendar dstEnd = dstEndDates.get(year);
        return date.compareTo(dstStart) == 1 && date.compareTo(dstEnd) == -1;
    }

}