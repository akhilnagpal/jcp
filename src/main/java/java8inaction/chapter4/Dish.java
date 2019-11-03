package java8inaction.chapter4;

import java.util.Arrays;
import java.util.List;

public class Dish {

  private final int calories;
  private final String name;
  private final boolean vegetarian;
  private final Type type;

  public static List<Dish> getDishes() {
    return Arrays.asList(new Dish("pork", 800, false, Dish.Type.MEAT), new Dish("beef", 700, false,
        Dish.Type.MEAT), new Dish("chicken", 400, false, Dish.Type.MEAT), new Dish("french fries",
        530, true, Dish.Type.OTHER), new Dish("rice", 350, true, Dish.Type.OTHER), new Dish(
        "season fruit", 120, true, Dish.Type.OTHER), new Dish("pizza", 550, true, Dish.Type.OTHER),
        new Dish("prawns", 300, false, Dish.Type.FISH), new Dish("salmon", 450, true,
            Dish.Type.FISH));
  }

  public Dish(String name, int calories, boolean vegetarian, Type type) {
    super();
    this.calories = calories;
    this.name = name;
    this.vegetarian = vegetarian;
    this.type = type;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public Type getType() {
    return type;
  }

  public int getCalories() {
    return calories;
  }

  public String getName() {
    return name;
  }

  public enum Type {
    MEAT, FISH, OTHER
  }

  @Override
  public String toString() {
    return "Dish [name=" + name + "]";
  }


}
