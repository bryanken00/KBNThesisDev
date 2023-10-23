package KBNAdminPanel.views;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class DateTester {
    public static void main(String[] args) {
        // Specify the year and month for which you want to find the Mondays and Sundays
        int year = 2023;
        Month month = Month.OCTOBER;

        // Create a LocalDate for the first day of the specified month
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        // Initialize currentMonday and currentSunday to the first Monday and first Sunday
        LocalDate currentMonday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate currentSunday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        // Index to keep track of the week
        int weekIndex = 1;

        // Iterate through the Mondays and Sundays in the month
        while (currentMonday.getMonth() == month) {
            System.out.println(weekIndex + "st index:");
            System.out.println("Monday: " + currentMonday);
            System.out.println("Sunday: " + currentSunday);

            // Move to the next Monday and Sunday
            currentMonday = currentMonday.plusWeeks(1);
            currentSunday = currentSunday.plusWeeks(1);

            weekIndex++;
        }

        // Check if the last Sunday falls in the next month
        if (currentSunday.getMonth() != month) {
            LocalDate firstSundayOfNextMonth = LocalDate.of(year, month.plus(1), 1)
                    .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            System.out.println("First Sunday of the next month: " + firstSundayOfNextMonth);
        }
    }
}
