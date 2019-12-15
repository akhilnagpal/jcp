package application.orderbook;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;

public class OrderHandlerImplTest {

  OrderHandler orderHandler;

  @Before
  public void setup() {
    orderHandler = OrderHandler.createOrderHandler();
    ExampleData.insertOrderBookData(orderHandler);
  }

  @Test
  public void testGetCurrentPriceSingleThreaded() {
    assertEquals(19.0, orderHandler.getCurrentPrice("MSFT", 6, Side.SELL), 0.001);
    assertEquals(19.588, orderHandler.getCurrentPrice("MSFT", 17, Side.SELL), 0.001);
    assertEquals(20.233, orderHandler.getCurrentPrice("MSFT", 30, Side.SELL), 0.001);
    assertEquals(15.0, orderHandler.getCurrentPrice("MSFT", 10, Side.BUY), 0.001);


  }

  @Test
  public void testGetCurrentPriceMultiThreaded() throws InterruptedException {

    ExecutorService executor = Executors.newFixedThreadPool(4);

    Callable<Double> currentPriceTask1 = () -> orderHandler.getCurrentPrice("MSFT", 6, Side.SELL);
    Callable<Double> currentPriceTask2 = () -> orderHandler.getCurrentPrice("MSFT", 17, Side.SELL);
    Callable<Double> currentPriceTask3 = () -> orderHandler.getCurrentPrice("MSFT", 30, Side.SELL);
    Callable<Double> currentPriceTask4 = () -> orderHandler.getCurrentPrice("MSFT", 10, Side.BUY);

    List<Callable<Double>> tasks =
        Arrays.asList(currentPriceTask1, currentPriceTask2, currentPriceTask3, currentPriceTask4);
    List<Future<Double>> futures = executor.invokeAll(tasks);

    try {
      assertEquals(19.0, futures.get(0).get(), 0.001);
      assertEquals(19.588, futures.get(1).get(), 0.001);
      assertEquals(20.233, futures.get(2).get(), 0.001);
      assertEquals(15.0, futures.get(3).get(), 0.001);
    } catch (ExecutionException ee) {
      ee.printStackTrace();
    }
    executor.shutdown();

  }
}
