package java8inaction.chapter8.templateMethod;

import java.util.function.Consumer;

// No longer an abstract class, so we customized the varying step through a function
// passed now as argument.
public class OnlineBankingWithLambda {
  public void processCustomer(Consumer<Customer> makeCustomerHappy) {
    // Algo Step 1 - say welcome message. I have enforced this in the algo
    System.out.println("Welcome");
    // Step 2 - Fetch Customer
    Customer customer = new Customer("Akhil", 42);
    // Step 3 - Do something with customer data, using Lamda, this is the only part allowed to
    // change
    makeCustomerHappy.accept(customer);
    // Step 4 - Bye message
    System.out.println("Bye");

  }
}
