package java8.lambda;

import java.util.function.ToIntBiFunction;

public class firstlambda {
	
	
	
	public static void main(String args[]) {
		
		Runnable run1= new Runnable() {
			public void run () {
				System.out.println("RUN1");
			}
		};
		
		Thread t1 = new Thread(run1);
		t1.start();
		
		Runnable run2 = () -> System.out.println("RUN2");
		
		Thread t2 = new Thread(run2);
		t2.start();
		
		ToIntBiFunction<Integer,Integer> add = (a,b) -> a + b;
		
		System.out.println(add.applyAsInt(1, 2));
	}

}
