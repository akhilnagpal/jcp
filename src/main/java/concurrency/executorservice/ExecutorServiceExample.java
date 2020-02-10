package concurrency.executorservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import concurrency.blockingqueue.Consumer;
import concurrency.blockingqueue.Producer;

public class ExecutorServiceExample {
	
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		ExecutorService executorService = Executors.newScheduledThreadPool(2);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		// NOW STARTING Producer and consumer threads using Executors 
		
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1024);
		Producer producer=new Producer(blockingQueue);
		Consumer consumer=new Consumer(blockingQueue);
		
		executorService.execute(producer);
		executorService.execute(consumer);
		
		// NOW USING CALLABLE to return AN OBJECT and USING FUTURE to get that object
		
		Future<Object> future = executorService.submit(new Callable<Object>( ) {

			@Override
			public Object call() throws Exception {
				System.out.println("Inside Callable");
				return "DONE";
			}
			
		});
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// you need to explictly shutdown the executor service
		executorService.shutdown();
	}

}
