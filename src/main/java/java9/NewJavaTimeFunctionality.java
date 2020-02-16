package java9;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.util.stream.Stream;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class NewJavaTimeFunctionality {

	public static void main(String[] args) {
		// New method in localDate - datesUntil
		LocalDate days = LocalDate.of(2020, 2, 1);
		Stream<LocalDate> dates = days.datesUntil(days.plusDays(7));
		dates.forEach(System.out::println);
		
		LocalDateTime current = LocalDateTime.now();
		
		Duration duration = Duration.between(current,current.plusHours(36));
		System.out.println(duration.toHours());
		// New method in Duration dividedBy
		System.out.println(duration.dividedBy(Duration.ofHours(2)));
		// new method in Duration truncatedTo
		System.out.println(duration.truncatedTo(ChronoUnit.DAYS).toDays());
		
		System.out.println(Clock.systemUTC().instant());
		
		// Get number of leap years from my birthday until date
		
		LocalDate birthday = LocalDate.of(1977, 7, 9);
		// Gives all dates in step of 1 year
		Stream<LocalDate> years = birthday.datesUntil(LocalDate.now(), Period.ofYears(1));
		years.forEach(System.out::println);
		// Finding Leap among all birthday years, by converting to year and then calling isLeap
		years = birthday.datesUntil(LocalDate.now(), Period.ofYears(1));
		years.map(localDate->Year.of(localDate.getYear())).filter(Year::isLeap).forEach(System.out::println);


	}

}
