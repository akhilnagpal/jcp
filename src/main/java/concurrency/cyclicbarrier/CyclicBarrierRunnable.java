package concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {
	
	CyclicBarrier barrier1;
	CyclicBarrier barrier2;
	
	public CyclicBarrierRunnable(CyclicBarrier barrier1,CyclicBarrier barrier2) {
		this.barrier1=barrier1;
		this.barrier2=barrier2;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " going to be wait at barrier 1");
		
			try {
				barrier1.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName() + " going to be wait at barrier 2");
		
		try {
			barrier2.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " is finished");
		
	}

}
