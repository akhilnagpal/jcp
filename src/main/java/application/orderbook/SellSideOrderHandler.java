package application.orderbook;

import java.util.HashMap;
import java.util.Map;

public class SellSideOrderHandler extends SideOrderHandler {

  private Map<String, Map<Integer, OrderBookRow>> asks = new HashMap<>();

  @Override
  protected Map<String, Map<Integer, OrderBookRow>> getOrderBook() {
    return asks;

  }

}
