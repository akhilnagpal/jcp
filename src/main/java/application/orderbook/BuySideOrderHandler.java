package application.orderbook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BuySideOrderHandler extends SideOrderHandler {

  private Map<String, Map<Integer, OrderBookRow>> bids = new HashMap<>();

  @Override
  protected Map<String, Map<Integer, OrderBookRow>> getOrderBook() {
    return bids;

  }

  @Override
  public Map<Integer, OrderBookRow> getSymbolOrderMap() {
    return new TreeMap<>(Collections.reverseOrder());
  }

}
