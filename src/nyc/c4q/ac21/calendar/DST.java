package nyc.c4q.ac21.calendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */

public class DST
{

    /**
     * Populates hash maps with the start and end time for DST in each year.
     *
     * @param startDates A hash map of the start date of DST in each year.
     * @param endDates   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates)
    {
        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");

        // FIXME: Write this code!

        for(String line : lines)
        { //For loop to iterate through each line.
            String[] temporary = line
                    .split(","); //temporary array to store the splitting of the arraylist
            Calendar start = DateTools.parseDate(
                    temporary[0]); //parsing the first value in the array to a calendar object
            Calendar end = DateTools.parseDate(
                    temporary[1]);//parsing the second value in the array to a calendar object

            Integer currentYear = start
                    .get(Calendar.YEAR); //Stores the year as an Integer for the hashmap

            startDates.put(currentYear,
                           start); // Adds the starting date for the DST to the start hashmap
            endDates.put(currentYear, end);// Adds the ending date for the DST to the end hashmap
        }
        // Each line in the file is of the form "start,end", where both dates
        // are in the same year.  This represents the dates DST starts and
        // ends in this year.
        //
        // Use DateTools.parseDate.
    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     *
     * @param date The date to check.
     * @return True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date)
    {
        // Create hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populate them.
        DST.getDSTDates(dstStartDates, dstEndDates);

        // FIXME: Write this code!
        int year = date.get(Calendar.YEAR);
        Calendar dstStartDate = dstStartDates.get(year);
        Calendar dstEndDate = dstEndDates.get(year);

        //        System.out.println(DateTools.formatDate(dstStartDate));
        //        System.out.println(DateTools.formatDate(dstEndDate));

        if(! date.before(dstStartDate) && ! date.after(dstEndDate))
        {
            return true;
        }
        else
        {
            return false;
        }

        //return !date.before(dstStartDate) && !date.after(dstEndDate);

    }

}