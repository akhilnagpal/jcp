package java8inaction.chapter8.templateMethod;

public class PrintAgeCustomerHappy extends OnlineBankingWithoutLamda {

  @Override
  public void makeCustomerHappy(Customer customer) {
    System.out.println(customer.age);
  }
}
