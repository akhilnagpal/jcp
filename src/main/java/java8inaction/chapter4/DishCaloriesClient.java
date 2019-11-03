package java8inaction.chapter4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DishCaloriesClient {

  public static void main(String[] args) {
    List<Dish> dishes =
        Arrays.asList(new Dish("salad", 150, true, Dish.Type.OTHER), new Dish("fries", 450, true,
            Dish.Type.OTHER), new Dish("fish", 50, false, Dish.Type.FISH));
    List<String> lowCalorieDishes =
        dishes.stream().filter((dish) -> dish.getCalories() < 400)
            .sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
    System.out.println(lowCalorieDishes);

    Stream<Dish> dishes2 = dishes.stream();
    dishes2.forEach(System.out::println);
    dishes2.forEach(System.out::println);
  }
}
