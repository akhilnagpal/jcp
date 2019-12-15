package concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

  public static void main(String args[]) {
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1024);
    Producer producer = new Producer(blockingQueue);
    Consumer consumer = new Consumer(blockingQueue);

    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);

    t1.start();
    t2.start();

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
