import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by Vilcho on 5/20/2017.
 */
public class Lab_p02_HolidaysBetweenTwoDates {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        String startDate = scanner.nextLine();
        String endDate = scanner.nextLine();

        int holidaysCount = 0;

        SimpleDateFormat dtFormatter = new SimpleDateFormat("dd.MM.yyyy");
        Date myStartDate = dtFormatter.parse(startDate);
        Date myEndDate = dtFormatter.parse(endDate);

        LocalDate start = myStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = myEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            java.time.DayOfWeek dateDayName = date.getDayOfWeek();
            boolean isSaturday = dateDayName.toString().equals("SATURDAY");
            boolean isSunday = dateDayName.toString().equals("SUNDAY");

            if (isSaturday || isSunday) {
                holidaysCount++;
            }
        }
        System.out.println(holidaysCount);

    }
}

//    How to iterate through range of Dates in Java?
//    http://stackoverflow.com/questions/4534924/how-to-iterate-through-range-of-dates-in-java
//
//
//    JodaTime is nice, however, for the sake of completeness and/or if you prefer API-provided facilities, here are the standard API approaches.
//
//    When starting off with java.util.Date instances like below:
//
//    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    Date startDate = formatter.parse("2010-12-20");
//    Date endDate = formatter.parse("2010-12-26");
//
//    Here's the legacy java.util.Calendar approach in case you aren't on Java8 yet:
//
//    Calendar start = Calendar.getInstance();
//start.setTime(startDate);
//    Calendar end = Calendar.getInstance();
//end.setTime(endDate);
//
//for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
//        // Do your job here with `date`.
//        System.out.println(date);
//    }
//
//    And here's Java8's java.time.LocalDate approach, basically exactly the JodaTime approach:
//
//    LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
//        // Do your job here with `date`.
//        System.out.println(date);
//    }
//
//    If you'd like to iterate inclusive the end date, then use !start.after(end) and !date.isAfter(end) respectively.
//
//    Date and time patterns
//    http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

//    Class Local Date
//    https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html





