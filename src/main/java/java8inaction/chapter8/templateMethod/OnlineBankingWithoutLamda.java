package java8inaction.chapter8.templateMethod;

// Outline of the Algo , with certain parts left abstract, to be filled in by child classes
public abstract class OnlineBankingWithoutLamda {
  public void processCustomer() {
    // Algo Step 1 - say welcome message. I have enforced this in the algo
    System.out.println("Welcome");
    // Step 2 - Fetch Customer
    Customer customer = new Customer("Akhil", 42);
    // Step 3 - Do something with customer data
    makeCustomerHappy(customer);
    // Step 4 - Bye message
    System.out.println("Bye");

  }

  protected abstract void makeCustomerHappy(Customer customer);
}
