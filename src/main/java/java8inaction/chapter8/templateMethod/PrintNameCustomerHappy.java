package java8inaction.chapter8.templateMethod;

public class PrintNameCustomerHappy extends OnlineBankingWithoutLamda {

  @Override
  public void makeCustomerHappy(Customer customer) {
    System.out.println(customer.name);
  }

}
