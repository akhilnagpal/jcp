package java8inaction.chapter8.lamdasinstrategy;

public class LowerCaseValidation implements ValidationStrategy {

  @Override
  public boolean validate(String s) {
    return s.matches("[a-z]+");
  }

}
