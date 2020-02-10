package concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	
	
	
	//http://tutorials.jenkov.com/java-util-concurrent/cyclicbarrier.html
	public static void main(String args[]) {
		
		Runnable barrierAction1 = () -> System.out.println("Barrier 1 action executed");
		Runnable barrierAction2 = () -> System.out.println("Barrier 2 Action executed");
		
		CyclicBarrier barrier1 = new CyclicBarrier(2,barrierAction1);
		CyclicBarrier barrier2 = new CyclicBarrier(2,barrierAction2);
		
		CyclicBarrierRunnable runnable = new CyclicBarrierRunnable(barrier1,barrier2);
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t2.start();
		t1.start();
		
	}

}
