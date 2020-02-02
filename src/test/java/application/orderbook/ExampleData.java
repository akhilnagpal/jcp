package application.orderbook;


public class ExampleData {

  public static void insertOrderBookData(OrderHandler orderHandler) {

    orderHandler.addOrder(new Order(1L, "MSFT", 8, 19, Side.SELL));
    orderHandler.addOrder(new Order(2L, "MSFT", 4, 19, Side.SELL));
    orderHandler.addOrder(new Order(3L, "MSFT", 16, 21, Side.SELL));
    orderHandler.addOrder(new Order(4L, "MSFT", 1, 21, Side.SELL));
    orderHandler.addOrder(new Order(5L, "MSFT", 7, 22, Side.SELL));

    orderHandler.addOrder(new Order(6L, "MSFT", 5, 13, Side.BUY));
    orderHandler.modifyOrder(new OrderModification(6L, 15, 10));

    orderHandler.addOrder(new Order(7L, "MSFT", 20, 15, Side.BUY));
    orderHandler.removeOrder(7L);

    orderHandler.addOrder(new Order(8L, "MSFT", 13, 10, Side.BUY));
    orderHandler.addOrder(new Order(9L, "MSFT", 13, 10, Side.BUY));

  }

}
