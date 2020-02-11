package application.cmcmarkets.orderbook;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class OrderHandlerImpl implements OrderHandler {

  private Map<Long, Order> orderCache = new HashMap<>();
  private SideOrderHandler buySideOrderHandler = new BuySideOrderHandler();
  private SideOrderHandler sellSideOrderHandler = new SellSideOrderHandler();
  private Map<Side, SideOrderHandler> sideOrderHandler = new EnumMap<>(Side.class);

  public OrderHandlerImpl() {
    sideOrderHandler.put(Side.BUY, buySideOrderHandler);
    sideOrderHandler.put(Side.SELL, sellSideOrderHandler);
  }


  @Override
  public void addOrder(Order order) {
    orderCache.put(order.getOrderId(), order);
    sideOrderHandler.get(order.getSide()).addOrder(order);
  }

  @Override
  public void removeOrder(long orderId) {
    Order order = orderCache.get(orderId);
    sideOrderHandler.get(order.getSide()).removeOrder(order);
    // Added so that cache unnecessary holds the removed order id, it could have been a memory leak.
    orderCache.remove(orderId);
  }

  @Override
  public void modifyOrder(OrderModification orderModification) {
    Order originalOrder = orderCache.get(orderModification.getOrderId());
    Order modifyOrder =
        new Order(orderModification.getOrderId(), originalOrder.getSymbol(),
            orderModification.getNewQuantity(), orderModification.getNewPrice(),
            originalOrder.getSide());
    orderCache.put(orderModification.getOrderId(), modifyOrder);
    sideOrderHandler.get(modifyOrder.getSide()).modifyOrder(modifyOrder, originalOrder);
  }

  @Override
  public double getCurrentPrice(String symbol, int quantity, Side side) {
    return sideOrderHandler.get(side).getCurrentPrice(symbol, quantity);
  }

}
