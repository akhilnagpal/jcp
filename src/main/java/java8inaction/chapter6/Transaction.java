package java8inaction.chapter6;

import java.util.Currency;

public class Transaction {
  private Currency currency;
  private int value;



  @Override
  public String toString() {
    return "Transaction [currency=" + currency + ", value=" + value + "]";
  }

  public Transaction(Currency currency, int value) {
    super();
    this.currency = currency;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }


}
