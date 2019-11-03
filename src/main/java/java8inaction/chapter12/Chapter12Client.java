package java8inaction.chapter12;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Chapter12Client {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.of(1977, 7, 9);
    int dayofMonth = localDate.getDayOfMonth();
    System.out.println(dayofMonth);
    int monthValue = localDate.getMonthValue();
    System.out.println(monthValue);
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    System.out.println(dayOfWeek);
    Month month = localDate.getMonth();
    LocalTime localTime = LocalTime.of(23, 23, 2);
    System.out.println(localTime);

    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
    System.out.println(localDateTime);

    Instant i = Instant.ofEpochSecond(4);
    System.out.println(Instant.now());

    Duration date = Duration.between(localTime, LocalTime.now());
    System.out.println(date.toHours());
    Period period = Period.between(localDate, LocalDate.now());
    System.out.println(period.getYears());

    LocalDate date2 = localDate.with(lastDayOfMonth());
    System.out.println(date2);

    System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
    System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));

    DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
    System.out.println(localDate.format(datePattern));
    LocalDate fortyTwo = LocalDate.parse("9. marzo 2014", datePattern);
    System.out.println(fortyTwo);

    ZoneId rome = ZoneId.of("Europe/Rome");
    ZonedDateTime romeLocalDate = localDate.atStartOfDay(rome);
    System.out.println(romeLocalDate);
  }
}
