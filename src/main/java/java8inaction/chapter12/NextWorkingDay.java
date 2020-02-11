package java8inaction.chapter12;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;


public class NextWorkingDay implements TemporalAdjuster {

  @SuppressWarnings("unused")
@Override
  public Temporal adjustInto(Temporal temporal) {
    Temporal nextWorkingDay;
    DayOfWeek dayOfweek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
    long dayToAdd = 1;
    if (dayOfweek.equals(DayOfWeek.SATURDAY)) {
      dayToAdd = 2;
    } else if (dayOfweek.equals(DayOfWeek.FRIDAY)) {
      dayToAdd = 3;
    }
    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
  }

}
