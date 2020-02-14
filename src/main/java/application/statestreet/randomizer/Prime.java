package application.statestreet.randomizer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Prime {
	PrimeSocketRunnable primeSocketRunnable;
	
	public Prime(int serverPortNumber) {
		primeSocketRunnable = new PrimeSocketRunnable(serverPortNumber);
	}
	
	public void run() {
		new Thread(primeSocketRunnable).start();
	}
	
	public void process(DataInputStream in, DataOutputStream out) throws InterruptedException {
		try {
			int testedNumber = in.readInt();
			boolean isPrime = checkPrime(testedNumber);
			out.writeInt(testedNumber);
			out.writeBoolean(isPrime);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}	
	
	//checking every integer (up to n to find out that a number is prime) 
	
		public boolean checkPrime(int number) 
		{ 
			
			if(number==2) {
				return true;
			}
			//check if n is a multiple of 2 or number is 1
			if(number==1 || number%2==0) {
				return false;
			}
			
			//if not, then just check the odds
			// to just checking half of the integers up to the square root (the odd ones really)
		    for(int numberCounter=3;numberCounter*numberCounter<=number;numberCounter+=2) {
			        if(number%numberCounter==0)
			            return false;
			}
		    
		    return true;
			
		}
		
		class PrimeSocketRunnable implements Runnable {
			private final Socket socket;
			private final DataInputStream in;
			private final DataOutputStream out;

			PrimeSocketRunnable(int serverPortNumber) {
				String hostName = "localhost";
				try {
					this.socket = new Socket(hostName, serverPortNumber);
					this.in = new DataInputStream(socket.getInputStream());
					this.out = new DataOutputStream(socket.getOutputStream());
				} catch (UnknownHostException e) {
					throw new RuntimeException(e);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public void run() {
				try {
					while (true) {
						try {
							process(in, out);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
				} finally {
					close();
				}
			}

			private void close() {
				try {
					socket.close();
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
