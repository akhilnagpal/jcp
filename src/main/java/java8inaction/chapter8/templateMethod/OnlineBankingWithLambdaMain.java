package java8inaction.chapter8.templateMethod;

import java.util.function.Consumer;

public class OnlineBankingWithLambdaMain {

  public static void main(String[] args) {
    // Algo step change
    Consumer<Customer> printAgeCustomerHappy =
        (Customer customer) -> System.out.println(customer.age);
    // Another Algo step change
    Consumer<Customer> printNameCustomerHappy =
        (Customer customer) -> System.out.println(customer.name);

    OnlineBankingWithLambda onlineBanking = new OnlineBankingWithLambda();
    onlineBanking.processCustomer(printAgeCustomerHappy);
    // // Changing part of algo
    onlineBanking.processCustomer(printNameCustomerHappy);

  }

}
