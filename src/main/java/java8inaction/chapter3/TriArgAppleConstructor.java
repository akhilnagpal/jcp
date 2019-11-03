package java8inaction.chapter3;

@FunctionalInterface
public interface TriArgAppleConstructor<String, Integer, Boolean, Apple> {
  public Apple getApple(String color, int weight, boolean rotten);
}
