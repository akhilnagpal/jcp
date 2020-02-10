package threadpool;

public class ThreadPool {
	
	private BlockingQueue<Runnable> queue;
	
	public ThreadPool(BlockingQueue<Runnable> queue,int threadsize) {
		this.queue = queue;
		int counter = 0;
		while (counter < threadsize) {
			TaskExecutor task = new TaskExecutor(queue);
			Thread t = new Thread(task, "threadname-"+counter);
			t.start();
		}
	}
	
	public void submit (Runnable task) {
		queue.enqueue(task);
	}

}
