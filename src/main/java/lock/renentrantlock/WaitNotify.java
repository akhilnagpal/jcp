package lock.renentrantlock;

public class WaitNotify {
	public static void main(String[] args) throws InterruptedException {
		
		StringBuilder message= new StringBuilder("Interthread");
		
		Thread consumer = new Thread(new Runnable () {

			@Override
			public void run() {
				synchronized (message) {
					try {
						message.wait();
						System.out.println(Thread.currentThread().getName() + message);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}
				
			}
			
		},"consumer1") ;
		
		Thread consumer2 = new Thread(new Runnable () {

			@Override
			public void run() {
				synchronized (message) {
					try {
						message.wait();
						System.out.println(Thread.currentThread().getName() + message);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}
				
			}
			
		},"consumer2") ;
		
		Thread producer = new Thread(new Runnable () {

			@Override
			public void run() {
				synchronized (message) {
					message.append(" communication");
					message.notifyAll();
				}
				
			}
			
		}) ;
		
		consumer.start();
		consumer2.start();
		Thread.sleep(1000);
		producer.start();
		
		
	}

}
