package java8inaction.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ExistingFunctionalInterfaces {

  static Map<String, Function<Integer, Fruit>> mapOfFruitConstructors = new HashMap<>();

  public static void main(String[] args) {
    // USing IntPredicateFunction
    ToIntFunction<List<String>> intBiFunction = (list) -> list.size();
    System.out.println(intBiFunction.applyAsInt(new ArrayList<String>()));
    IntToLongFunction intToLongFunction = (count) -> (count);
    System.out.println(intToLongFunction.applyAsLong(1));
    BooleanSupplier booleanSup = () -> true;
    System.out.println(booleanSup.getAsBoolean());

    Supplier<Apple> noArgConstructor = Apple::new;
    Apple apple = noArgConstructor.get();

    Function<Integer, Apple> oneArgConstructor = Apple::new;
    apple = oneArgConstructor.apply(150);

    BiFunction<String, Integer, Apple> twoArgConstructor = Apple::new;
    apple = twoArgConstructor.apply("green", 150);

    mapOfFruitConstructors.put("apple", Apple::new);
    mapOfFruitConstructors.put("orange", Orange::new);

    System.out.println(mapOfFruitConstructors.get("apple").apply(10));
    System.out.println(mapOfFruitConstructors.get("orange").apply(10));

    TriArgAppleConstructor<String, Integer, Boolean, Apple> threeArgCon = Apple::new;
    System.out.println(threeArgCon.getApple("green", 150, false));



  }
}
