package concurrency.join;

public class ThreadJoin {
	
	
	public static void main(String args[]) throws InterruptedException {
		Thread t1 = new Thread(new Runnable( ) {

			@Override
			public void run() {
				System.out.println("Thread 1 about to sleep");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 1 awake");
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable( ) {

			@Override
			public void run() {
				System.out.println("Thread 2 about to sleep");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2 awake");
				
			}
			
		});
		
		t1.start();
		
		t1.join();
		System.out.println("ThreadJoin awake");
		t2.start();
		
	}

}
