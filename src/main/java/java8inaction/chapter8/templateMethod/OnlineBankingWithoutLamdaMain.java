package java8inaction.chapter8.templateMethod;

public class OnlineBankingWithoutLamdaMain {

  public static void main(String[] args) {
    OnlineBankingWithoutLamda onlineBankingWithoutLamda = new PrintAgeCustomerHappy();
    onlineBankingWithoutLamda.processCustomer();
    // Changing part of algo
    onlineBankingWithoutLamda = new PrintNameCustomerHappy();
    onlineBankingWithoutLamda.processCustomer();
  }
}
