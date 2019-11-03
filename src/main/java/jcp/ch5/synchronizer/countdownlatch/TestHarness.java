package jcp.ch5.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Using Countdown latch for starting and stopping threads for timings tests
 * It is also measuring the true extent of contention
 * @author Akhil Nagpal
 *
 */
public class TestHarness {
	
	public long timeTasks(Runnable task , int nThreads) throws InterruptedException {
		CountDownLatch startGate = new CountDownLatch(1);
		CountDownLatch endGate = new CountDownLatch(nThreads);		
		
		for (int aThread=0;aThread<nThreads;aThread++) {
			Thread thread = new Thread(new Runnable( ) {

				@Override
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();							
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();						
					}				
					
				}
				
			});
			thread.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end-start;
		
		
	}
	
	public long lamdaTimeTasks(Runnable task , int nThreads) throws InterruptedException {
		CountDownLatch startGate = new CountDownLatch(1);
		CountDownLatch endGate = new CountDownLatch(nThreads);		
		
		for (int aThread=0;aThread<nThreads;aThread++) {
			Thread thread = new Thread(( ) -> {				
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();							
						}						
					} catch (InterruptedException e) {
						e.toString();						
					}			
				
			});
			thread.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end-start;
		
		
	}
	

}
