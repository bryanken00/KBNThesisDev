package KBNAdminPanel.views;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTester {
    public static void main(String[] args) {
        LocalDate firstDayOfMonth = LocalDate.of(2023, 10, 1); // October 2023
        LocalDate currentMonday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate currentSunday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        int weekIndex = 1;

        while (currentMonday.getMonth() == firstDayOfMonth.getMonth()) {
            System.out.println(weekIndex + "st index:");
            System.out.println("Monday: " + currentMonday);

            // Check if the first Sunday is less than the first Monday
            if (currentSunday.isBefore(currentMonday)) {
                currentSunday = currentSunday.plusWeeks(1); // Move to the next Sunday
            }

            // Print the Sunday
            System.out.println("Sunday: " + currentSunday);

            // Move to the next Monday
            currentMonday = currentMonday.plusWeeks(1);
            currentSunday = currentSunday.plusWeeks(1);

            weekIndex++;
        }
    }
}
