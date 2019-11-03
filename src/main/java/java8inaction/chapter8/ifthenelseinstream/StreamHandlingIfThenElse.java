package java8inaction.chapter8.ifthenelseinstream;

import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;

public class StreamHandlingIfThenElse {
  public static void main(String args[]) {
    // Instead of using if then else using imperative programming
    // I used predicates in filter to seperate out the evens/odds
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    List<Integer> evenIntList = intList.stream().filter(i -> i % 2 == 0).collect(toList());
    List<Integer> oddIntList = intList.stream().filter(i -> i % 2 != 0).collect(toList());
    evenIntList.stream().forEach(System.out::println);
    oddIntList.stream().forEach(System.out::println);

  }
}
