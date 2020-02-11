package application.cmcmarkets.orderbook;

public final class Order {

  private final long orderId;
  private final String symbol;
  private final int quantity;
  private final int price;
  private final Side side;

  public Order(long orderId, String symbol, int quantity, int price, Side side) {
    super();
    this.orderId = orderId;
    this.symbol = symbol;
    this.quantity = quantity;
    this.price = price;
    this.side = side;
  }

  public long getOrderId() {
    return orderId;
  }

  public String getSymbol() {
    return symbol;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getPrice() {
    return price;
  }

  public Side getSide() {
    return side;
  }



  @Override
  public String toString() {
    return "Order [orderId=" + orderId + ", symbol=" + symbol + ", quantity=" + quantity
        + ", price=" + price + ", side=" + side + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (orderId ^ (orderId >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (orderId != other.orderId)
      return false;
    return true;
  }



}
