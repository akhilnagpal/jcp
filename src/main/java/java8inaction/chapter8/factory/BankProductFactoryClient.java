package java8inaction.chapter8.factory;

import java.io.IOException;

public class BankProductFactoryClient {

  public static void main(String args[]) throws IOException {

    BankProduct bankProduct = BankProductFactory.createBankProduct("loan");
    System.out.println(bankProduct.getClass().getSimpleName());
  }
}
