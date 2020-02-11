package application.cmcmarkets.orderbook;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class SideOrderHandler {

  protected abstract Map<String, Map<Integer, OrderBookRow>> getOrderBook();

  public Map<Integer, OrderBookRow> getSymbolOrderMap() {
    return new TreeMap<>();
  }

  public void addOrder(Order order) {
    Map<Integer, OrderBookRow> orderBookRows = getOrderBook().get(order.getSymbol());

    if (orderBookRows == null) {
      orderBookRows = getSymbolOrderMap();
      createOrderBookRow(order, orderBookRows);
      getOrderBook().put(order.getSymbol(), orderBookRows);
    } else {
      // Symbol Already exists
      OrderBookRow orderBookRow = orderBookRows.get(order.getPrice());
      if (orderBookRow == null) {
        createOrderBookRow(order, orderBookRows);
      } else {
        orderBookRow.addOrder(order);
      }
    }
  }

  private void createOrderBookRow(Order order, Map<Integer, OrderBookRow> orderBookRows) {
    OrderBookRow orderBookRow = new OrderBookRow();
    orderBookRow.addOrder(order);
    orderBookRows.put(order.getPrice(), orderBookRow);
  }

  public void removeOrder(Order order) {
    Map<Integer, OrderBookRow> orderBookRows = getOrderBook().get(order.getSymbol());
    OrderBookRow orderBookRow = orderBookRows.get(order.getPrice());
    orderBookRow.removeOrder(order);
    if (orderBookRow.getOrderCount() == 0) {
      orderBookRows.remove(order.getPrice());
    }
  }

  public double getCurrentPrice(String symbol, int quantity) {
    Map<Integer, OrderBookRow> orderBookRows = getOrderBook().get(symbol);
    int leftOverQuantity = quantity;
    double averagePriceCummulative = 0.0;
    Iterator<Entry<Integer, OrderBookRow>> iterator = orderBookRows.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<Integer, OrderBookRow> entry = iterator.next();
      // not looping through all orders. Quantity is updated for every add/remove order.
      OrderBookRow orderBookRow = entry.getValue();
      int orderBookQuantity = orderBookRow.getOrderBookRowQuantity();
      if (orderBookQuantity >= leftOverQuantity) {
        averagePriceCummulative = averagePriceCummulative + leftOverQuantity * entry.getKey();
        break;
      } else {
        averagePriceCummulative = averagePriceCummulative + orderBookQuantity * entry.getKey();
        leftOverQuantity -= orderBookQuantity;
      }
    }
    return Double.valueOf(averagePriceCummulative) / Double.valueOf(quantity);

  }

  public void modifyOrder(Order modifyOrder, Order originalOrder) {
    removeOrder(originalOrder);
    addOrder(modifyOrder);
  }

}
