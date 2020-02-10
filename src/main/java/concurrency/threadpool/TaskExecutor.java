package concurrency.threadpool;

public class TaskExecutor implements Runnable {
	BlockingQueue<Runnable> blockingQueue;
	
	public TaskExecutor(BlockingQueue<Runnable> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}

	@Override
	public void run() {
		while(true) {			
			Runnable task = blockingQueue.dequeue();
			System.out.println(Thread.currentThread().getName() + " is executing " + task);
			task.run();
			System.out.println(Thread.currentThread().getName() + " has finished " + task);
		}

	}

}
