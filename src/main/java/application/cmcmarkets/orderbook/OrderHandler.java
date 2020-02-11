package application.cmcmarkets.orderbook;

public interface OrderHandler {

  void addOrder(Order order);

  void removeOrder(long orderId);

  void modifyOrder(OrderModification orderModification);

  static OrderHandler createOrderHandler() {
    return new OrderHandlerImpl();
  }

  double getCurrentPrice(String symbol, int price, Side side);
}
