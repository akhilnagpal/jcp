package lock.renentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantLock2 {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock rentrantLock = new ReentrantLock(true);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				rentrantLock.tryLock();
				if(rentrantLock.isHeldByCurrentThread()) {
					System.out.println(Thread.currentThread() + "holds lock");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						rentrantLock.unlock();
					}
				}
				
				
				
			}
			
		},"Thread-1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				rentrantLock.tryLock();
				if(rentrantLock.isHeldByCurrentThread()) {
					System.out.println(Thread.currentThread() + "holds lock");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						rentrantLock.unlock();
					}
				}
				
			}
			
		},"Thread-2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Main thread");
	}

}
