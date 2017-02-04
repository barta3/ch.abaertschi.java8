package overview;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by adrian on 25.12.16.
 */
public class Dates {

    public static void main(String... args) {
        // Clock
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        // TimeZones
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zurich = ZoneId.of("Europe/Zurich");
        System.out.println(zurich.getRules());

        // LocalTime (time without timezone)
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = LocalTime.now(ZoneId.of("Brazil/East"));
        long minutes = ChronoUnit.MINUTES.between(t1, t2);
        System.out.println(minutes);

        // Factory LocalTime
        LocalTime last = LocalTime.of(23, 59, 59);
        System.out.println(last);

        // Parsing
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime cananda = LocalTime.parse("13:43", formatter);
        System.out.println(cananda);

        // LocalDate
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(LocalDate.MIN);

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate myBirthDay = LocalDate.of(1990, Month.JULY, 25);
        System.out.println(myBirthDay.getDayOfWeek());

        // Parse Date
        DateTimeFormatter dtf = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.CANADA);
        System.out.println(dtf.format(LocalDate.now()));
        LocalDate xmas = LocalDate.parse("25-Dec-2016", dtf);
        System.out.println(xmas);

        // LocalDateTime
        LocalDateTime firstDay = LocalDateTime.of(2017, Month.JANUARY, 3, 9, 0);
        System.out.println(firstDay.getDayOfWeek());

        Instant instant1 = firstDay.atZone(ZoneId.systemDefault()).toInstant();
        Date oldDate = Date.from(instant1);
        System.out.println(oldDate);

        // Formatting
        dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(dtf.format(firstDay));

    }
}
