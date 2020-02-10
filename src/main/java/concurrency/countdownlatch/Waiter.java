package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {
	
	CountDownLatch countDownLatch;

	public Waiter(CountDownLatch countDownLatch) {
		this.countDownLatch=countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Invoking await....");
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished");
	}

}
