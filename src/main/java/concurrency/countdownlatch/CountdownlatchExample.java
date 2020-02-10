package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownlatchExample {
	
	CountDownLatch countDownLatch;
	
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Waiter waiter = new Waiter(countDownLatch);
		Decrementer decrementer = new Decrementer(countDownLatch);
		
		executorService.execute(waiter);
		executorService.execute(decrementer);	
		
	}

}
