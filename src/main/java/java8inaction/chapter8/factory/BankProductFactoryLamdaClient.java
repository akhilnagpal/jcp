package java8inaction.chapter8.factory;

import java.io.IOException;

public class BankProductFactoryLamdaClient {

  public static void main(String args[]) throws IOException {
    BankProduct bankProduct = BankProductFactoryLamda.createBankProduct("loan");
    System.out.println(bankProduct.getClass().getSimpleName());
    bankProduct = BankProductFactoryLamda.createBankProduct("akhil");
  }

  public static BankProduct createBankLoadProduct() {
    return new Loan();
  }
}
