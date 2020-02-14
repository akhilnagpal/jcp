package application.statestreet.randomizer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Randomizer {
	
	DistributedQueue<Integer,PrimeInteger> distributedQueue;
	
	public Randomizer() {
		this(9090);
	}
	
	public void run() {
		new Thread(new RandomGenerator()).start();
		new Thread(new Receiver()).start();
		distributedQueue.start();
	}
	
	public Randomizer (int i) {
		distributedQueue = new DistributedQueue<>(i,this::process);
	}
	
	
	class RandomGenerator implements Runnable {
		Random random = new Random();
		
		@Override
		public void run() {
			while (true) {
				int number  = random.nextInt(100)+1;
				try {
					distributedQueue.put(number);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}

	/** 
	 * Receive results from Prime checkers and print them 
	 */
	class Receiver implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					PrimeInteger r = distributedQueue.take();
					if (r.isPrime()) {
						System.out.println(String.format("Number %d is a prime number", r.getPrimeNumber()));
					} else {
						System.out.println(String.format("Number %d is NOT prime number", r.getPrimeNumber()));
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}
	
	public PrimeInteger process(
			DataOutputStream out,
			DataInputStream in,
			Integer input) {
		try {
			out.writeInt(input);

			int number = in.readInt(); 
			if (number != input) {
				throw new RuntimeException("verification check failed"); 
			}
			boolean isPrime = in.readBoolean();

			return new PrimeInteger(number, isPrime);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
