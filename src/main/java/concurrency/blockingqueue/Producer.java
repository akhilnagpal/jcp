package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	BlockingQueue<Integer> blockingQueue;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put(1);
			Thread.sleep(1000);
			blockingQueue.put(2);
			Thread.sleep(1000);
			blockingQueue.put(3);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
