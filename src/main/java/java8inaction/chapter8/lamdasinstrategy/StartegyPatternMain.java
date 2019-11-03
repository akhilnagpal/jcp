package java8inaction.chapter8.lamdasinstrategy;

public class StartegyPatternMain {

  public static void main(String[] args) {
    String s = "check";

    ValidationStrategy validationStrategy = new AllNumeric();
    System.out.println(validationStrategy.validate(s));

    validationStrategy = new LowerCaseValidation();
    System.out.println(validationStrategy.validate(s));

    // Now we had to create two classes and boilerplate code to implement a interface
    // Also we see Validation Strategy only has a single method, so a functional interface.

    // Lets change the above using a Lamdas
    ValidationStrategy numericValidationStrategy = (String str) -> str.matches("\\d+");
    ValidationStrategy lowercaseValidationStrategy = (String str) -> str.matches("[a-z]+");

    System.out.println(numericValidationStrategy.validate(s));
    System.out.println(lowercaseValidationStrategy.validate(s));

    // Same results , we just needed a validation strategy lamdas for each class we have implemented


  }

}
