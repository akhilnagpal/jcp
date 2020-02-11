package lock.renentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadwriteLockImplementation {
	
	List<String> products = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		ReadwriteLockImplementation shoppingCart = new ReadwriteLockImplementation();
		shoppingCart.add("Iphone");
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock (true);
		
		Thread readThread = new Thread (new Runnable( ) {

			@Override
			public void run() {
				
				ReadLock readLock = readWriteLock.readLock();
				
				readLock.lock();
				System.out.println(shoppingCart.getProduct(1));
				readLock.unlock();
			}
			
		});
		Thread writeThread = new Thread (new Runnable( ) {

			@Override
			public void run() {
				
				WriteLock writeLock = readWriteLock.writeLock();
				
				writeLock.lock();
				shoppingCart.add("IphoneX");
				System.out.println("thread write lock obtained");
				writeLock.unlock();
			}
			
		});
		

		readThread.start();
		writeThread.start();
		
		
	}

	private void add(String string) {
		products.add(string);		
	}
	
	public String getProduct(int i) {
		return products.get(i);
	}

}
