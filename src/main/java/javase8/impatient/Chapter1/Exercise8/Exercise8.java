package javase8.impatient.Chapter1.Exercise8;

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {

	public static void main(String[] args) throws InterruptedException {
		String[] names = {"Peter","Paul","Mary"};
		List<Runnable> runners = new ArrayList<>();
		
		// USing Lamda Expression
		for (String name:names) {
			runners.add(() -> System.out.println(name));
		}
//		
		//Using method references
//		for (String name:names) {
//			runners.add(System.out::println);
//		}
		
		for(Runnable runnable:runners) {
			Thread thread = new Thread(runnable);
			thread.start();
			thread.join();
		}
		
		// You cannot use traditional for loop as i is getting changed after every iteration
		// The free variables used from enclosing block has to be read-only
		// Un-comment below and try again
		
//		for (int i =0;i<names.length;i++) {
//			runners.add(() -> System.out.println(names[i]));
//		}

	}

}
