package java8inaction.chapter3;

import static java.util.Comparator.comparing;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComparatorChainingClient {

  public static void main(String args[]) {
    Comparator<Apple> comparatorByWeight = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
    comparatorByWeight = comparing((Apple a) -> a.getWeight());
    comparatorByWeight = comparing(Apple::getWeight);
    Comparator<Apple> reverseComparatorByWeight = comparatorByWeight.reversed();

    List<Apple> apples =
        Arrays.asList(new Apple("green", 150), new Apple("red", 450), new Apple("green", 450),
            new Apple("red", 150));
    apples.sort(reverseComparatorByWeight);
    System.out.println(apples);
    // Constructor chaining
    Comparator<Apple> reverseComparatorByWeightAndThenColour =
        reverseComparatorByWeight.thenComparing(Apple::getColour);
    apples.sort(reverseComparatorByWeightAndThenColour);
    System.out.println(apples);

    Predicate<Apple> redApplePredicate = (Apple apple1) -> apple1.getColour().equals("red");
    Predicate<Apple> notRedApplePredicate = redApplePredicate.negate();

    for (Apple apple : apples) {
      System.out.println("Apple " + apple.getColour() + " " + notRedApplePredicate.test(apple));
    }

    Predicate<Apple> redAppleAndHeaveApplesPredicate =
        redApplePredicate.and((apple) -> apple.getWeight() > 150);

    for (Apple apple : apples) {
      System.out.println(apple + " " + redAppleAndHeaveApplesPredicate.test(apple));
    }

    Function<Integer, Integer> firstFunction = (first) -> first + 1;
    Function<Integer, Integer> secondFunction = (first) -> first * 2;
    Function<Integer, Integer> aggregrateFunction = firstFunction.andThen(secondFunction);
    System.out.println(aggregrateFunction.apply(1));
    Function<Integer, Integer> composeFunction = firstFunction.compose(secondFunction);
    System.out.println(composeFunction.apply(1));

  }
}
