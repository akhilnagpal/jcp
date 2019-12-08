package java8inaction.chapter6;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;
import java.util.ArrayList;
import java.util.Currency;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java8inaction.chapter4.CalorificLevel;
import java8inaction.chapter4.Dish;

public class Chapter6Client {

  public static void main(String[] args) {
    List<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction(Currency.getInstance("GBP"), 100));
    transactions.add(new Transaction(Currency.getInstance("GBP"), 200));
    transactions.add(new Transaction(Currency.getInstance("INR"), 100));
    transactions.add(new Transaction(Currency.getInstance("INR"), 200));

    Map<Currency, List<Transaction>> txByCurr =
        transactions.stream().collect(groupingBy(Transaction::getCurrency));
    System.out.print(txByCurr);
    List<Dish> dishes = Dish.getDishes();;

    System.out.println(Dish.getDishes().stream().count());
    System.out.println(Dish.getDishes().stream().collect(counting()));
    dishes.stream().collect(maxBy(comparingInt(Dish::getCalories))).ifPresent(System.out::println);;
    dishes.stream().collect(minBy(comparingInt(Dish::getCalories))).ifPresent(System.out::println);;;
    System.out.println(dishes.stream().collect(summingInt(Dish::getCalories)));
    System.out.println(dishes.stream().collect(averagingInt(Dish::getCalories)));
    IntSummaryStatistics statistics = dishes.stream().collect(summarizingInt(Dish::getCalories));
    System.out.println(statistics);
    System.out.println(dishes.stream().map(Dish::getName).collect(joining(",")));

    int numberOfCalories = dishes.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    // Alternative of joining
    String menu = dishes.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));

    Map<Dish.Type, List<Dish>> dishTypeByMeat = dishes.stream().collect(groupingBy(Dish::getType));
    System.out.println(dishTypeByMeat);

    Map<CalorificLevel, List<Dish>> dishTypeByCalories =
        dishes.stream().collect(groupingBy((Dish dish) -> {
          if (dish.getCalories() <= 400)
            return CalorificLevel.DIET;
          if (dish.getCalories() <= 400)
            return CalorificLevel.NORMAL;
          else
            return CalorificLevel.FAT;
        }));

    Map<Dish.Type, Map<CalorificLevel, List<Dish>>> dishesByMeatByCalories =
        dishes.stream().collect(groupingBy(Dish::getType, groupingBy((Dish dish) -> {
          if (dish.getCalories() <= 400)
            return CalorificLevel.DIET;
          if (dish.getCalories() <= 400)
            return CalorificLevel.NORMAL;
          else
            return CalorificLevel.FAT;
        })));

    Map<Dish.Type, Long> dishCountByType =
        dishes.stream().collect(groupingBy(Dish::getType, counting()));
    // {MEAT=3, FISH=2, OTHER=4}
    System.out.println(dishCountByType);

    Map<Dish.Type, Optional<Dish>> dishOptionalByTypeWithMaxCalories =
        dishes.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
    System.out.println(dishOptionalByTypeWithMaxCalories);


    Map<Dish.Type, Dish> dishByTypeWithMaxCalories =
        dishes.stream().collect(
            groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    System.out.println(dishByTypeWithMaxCalories);

    Map<Dish.Type, Integer> dishByCaloriesTypeWithTotalCalories =
        dishes.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

    System.out.println(dishByCaloriesTypeWithTotalCalories);

    Map<Dish.Type, Set<CalorificLevel>> dishByCaloriesLevelForEachDishType =
        dishes.stream().collect(groupingBy(Dish::getType, mapping((Dish dish) -> {
          if (dish.getCalories() <= 400)
            return CalorificLevel.DIET;
          if (dish.getCalories() <= 700)
            return CalorificLevel.NORMAL;
          else
            return CalorificLevel.FAT;
        }, toSet())));

    System.out.println(dishByCaloriesLevelForEachDishType);

    Map<Boolean, List<Dish>> dishByVegOrNonVeg =
        dishes.stream().collect(partitioningBy(Dish::isVegetarian));
    System.out.println(dishByVegOrNonVeg.get(true));
    Map<Boolean, Map<Dish.Type, List<Dish>>> dishByVegOrNonVegByDishType =
        dishes.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    System.out.println(dishByVegOrNonVegByDishType);

    Map<Boolean, Optional<Dish>> dishByVegOrNonVegWithMaxCalories =
        dishes.stream().collect(
            partitioningBy(Dish::isVegetarian, maxBy(comparingInt(Dish::getCalories))));
    System.out.println(dishByVegOrNonVegWithMaxCalories);

    Map<Boolean, Dish> dishByVegOrNonVegWithMaxCalories2 =
        dishes.stream().collect(
            partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    System.out.println(dishByVegOrNonVegWithMaxCalories2);

  }
}
