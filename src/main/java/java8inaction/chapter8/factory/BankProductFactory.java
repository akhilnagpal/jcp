package java8inaction.chapter8.factory;

public abstract class BankProductFactory {

  public static BankProduct createBankProduct(String productName) {
    switch (productName) {
      case ("loan"):
        return new Loan();
      case ("stock"):
        return new Stock();
      default:
        throw new RuntimeException("product " + productName + " not yet implemented");
    }
  }

}
