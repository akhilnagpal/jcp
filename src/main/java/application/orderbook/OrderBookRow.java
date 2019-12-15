package application.orderbook;

import java.util.Deque;
import java.util.LinkedList;

public class OrderBookRow {

  private int quantity = 0;
  private Deque<Order> orders = new LinkedList<>();

  public int getOrderCount() {
    return orders.size();
  }

  public void addOrder(Order order) {
    orders.offer(order);
    quantity += order.getQuantity();
  }

  public void removeOrder(Order order) {
    orders.remove();
    quantity -= order.getQuantity();
  }

  public int getOrderBookRowQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "OrderBookRow [quantity=" + quantity + ", orders=" + orders + "]";
  }


}
