package java8inaction.chapter8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BankProductFactoryLamda {

  private static Map<String, Supplier<BankProduct>> productMap = new HashMap<>();

  static {
    productMap.put("loan", Loan::new);
    productMap.put("stock", Stock::new);
  }

  public static BankProduct createBankProduct(String name) {
    Supplier<BankProduct> bankProduct = productMap.get(name);
    if (bankProduct != null) {
      return bankProduct.get();
    }
    throw new RuntimeException("product " + name + " not yet implemented");
  }
}
