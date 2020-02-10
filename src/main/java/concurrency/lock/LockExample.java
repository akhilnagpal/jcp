package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
	
	
	public static void main(String args[]) {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		
		t1.start();
		t2.start();
	}
	
	

}

class Counter implements Runnable {
	int count=0;
	Lock lock = new ReentrantLock();
	
	
	// This one can be used for read write lock.
	// https://stackoverflow.com/questions/18354339/reentrantreadwritelock-whats-the-difference-between-readlock-and-writelock
	ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();
	
	
	@Override
	public void run() {
		while(count<10) {		
		if(lock.tryLock()==true) {
			++count;
			System.out.println(Thread.currentThread().getName() + " count =" + count);
			lock.unlock();			
		}		
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

		
	}
	
}
