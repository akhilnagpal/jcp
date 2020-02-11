package java8inaction.chapter3;

@SuppressWarnings("hiding")
@FunctionalInterface
public interface TriArgAppleConstructor<String, Integer, Boolean, Apple> {
  public Apple getApple(String color, int weight, boolean rotten);
}
