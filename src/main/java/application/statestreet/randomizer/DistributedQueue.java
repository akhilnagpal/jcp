package application.statestreet.randomizer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DistributedQueue <INPUT,OUTPUT> {
	private final BlockingQueue<INPUT> inputQueue = new LinkedBlockingQueue<>(100);
	private final BlockingQueue<OUTPUT> outputQueue = new LinkedBlockingQueue<OUTPUT>();
	private ServerSocketThread<INPUT,OUTPUT> serverSocketThread;
	
	public void start() {
		new Thread(serverSocketThread).start();
	}
	
	public DistributedQueue(int i,ClientProxy<INPUT,OUTPUT> clientProxy) {
		serverSocketThread = new ServerSocketThread<INPUT,OUTPUT>(i, inputQueue, outputQueue, clientProxy);
	}
	
	public void put(INPUT e) throws InterruptedException {
		inputQueue.put(e);
	}
	
	public OUTPUT take() throws InterruptedException {
		return outputQueue.take();
	}

}
