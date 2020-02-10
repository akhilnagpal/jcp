package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {
	
	CountDownLatch countDownLatch;

	public Decrementer(CountDownLatch countDownLatch) {
		this.countDownLatch=countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			countDownLatch.countDown();
			System.out.println("3....");
			Thread.sleep(1000);
			countDownLatch.countDown();
			System.out.println("2....");
			Thread.sleep(1000);
			countDownLatch.countDown();
			System.out.println("1....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
