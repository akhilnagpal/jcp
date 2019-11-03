package javase8.impatient.Chapter1.Exercise7;

import java.util.ArrayList;
import java.util.List;

public class Exercise7 {
	
	public static void main(String args[]) throws InterruptedException {
		List<Runnable> runnablesList = andThen (() -> System.out.println("First Runnable"),() -> System.out.println("Second Runnable"));
		
		for(Runnable runnable:runnablesList) {
			Thread thread = new Thread(runnable);
			thread.start();
			thread.join();
		}
		
	}
	
	
	static List<Runnable> andThen(Runnable ...runnables ) {
		List<Runnable> runnablesList= new ArrayList<Runnable>();
		
		for(Runnable runnable:runnables) {
			runnablesList.add(runnable);
		}
		
		return runnablesList;
			
	}

}
