package java8inaction.chapter5;

import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java8inaction.chapter4.Dish;

public class AllStreamOperations {

  @SuppressWarnings("unused")
public static void main(String[] args) {
    List<Dish> dishes = Dish.getDishes();

    // Get unique elements
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2);
    numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    // Limit
    dishes.stream().limit(3).forEach(System.out::println);
    // Skip
    dishes.stream().skip(3).forEach(System.out::println);
    System.out.println("----------------");
    // Filter the first two MEAT dishes
    dishes.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).limit(2)
        .forEach(System.out::println);
    // Getting the length of all dish Names
    dishes.stream().map(Dish::getName).map(String::length).forEach(System.out::println);

    // Get distinct characters from the String array containing two elements using flatMap
    List<String> names = Arrays.asList("Hello", "World");
    String[] namesArray = {"Hello", "World"};
    // Arrays.stream converts String Array to Stream<String>
    Stream<String> namesArrayString = Arrays.stream(namesArray);
    // For each element of stream of string [], Arrays::stream converts each Array into a
    // Stream<String>
    // Hence below expression yields Stream<Stream<Sting>>
    names.stream().map(word -> word.split("")).map(Arrays::stream);
    // To solve above conundrum, we will flatten the stream of stream of string to Stream of string.
    names.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
        .forEach(System.out::println);

    List<Integer> listIntegers = Arrays.asList(1, 2, 3, 4, 5);

    List<Integer> squarelistIntegers = listIntegers.stream().map(i -> i * i).collect(toList());
    System.out.println(squarelistIntegers);

    List<Integer> number1 = Arrays.asList(1, 2, 3);
    List<Integer> number2 = Arrays.asList(4, 5);

    List<Object> objects =
        number1.stream().flatMap(num1 -> number2.stream().map(num2 -> new int[] {num1, num2}))
            .collect(toList());
    number1
        .stream()
        .flatMap(
            num1 -> number2.stream().filter(num2 -> (num1 + num2) % 3 == 0)
                .map(num2 -> new int[] {num1, num2})).forEach(System.out::println);

    if (dishes.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("Vegeterian menu");
    }
    System.out.println(dishes.stream().allMatch(dish -> dish.getCalories() < 1000));
    System.out.println(dishes.stream().noneMatch(dish -> dish.getCalories() < 1000));
    Optional<Dish> dish = dishes.stream().filter(Dish::isVegetarian).findAny();
    dish.ifPresent(System.out::println);

    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> sqrt3 =
        numbers1.stream().map(x -> x * x).filter(num -> num % 3 == 0).findFirst();
    sqrt3.ifPresent(System.out::println);

    numbers1.stream().reduce(0, (a, b) -> a + b);
    System.out.println(numbers1.stream().reduce(0, Integer::sum));
    numbers1.stream().reduce(Integer::max).ifPresent(System.out::println);

    System.out.println(dishes.stream().count());

    dishes.stream().map(d -> 1).reduce(Integer::sum).ifPresent(System.out::println);;

    System.out.println(IntStream.rangeClosed(0, 25).count());

    Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

    Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(5)
        .forEach(t -> System.out.println("[" + t[0] + "," + t[1] + "]"));
    Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).map(t -> t[0]).limit(8)
        .forEach(System.out::println);
    IntStream.generate(() -> 1).limit(5).forEach(System.out::println);



  }
}
