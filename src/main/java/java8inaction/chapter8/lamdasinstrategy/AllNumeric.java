package java8inaction.chapter8.lamdasinstrategy;

public class AllNumeric implements ValidationStrategy {

  @Override
  public boolean validate(String s) {
    return s.matches("\\d+");
  }
}
