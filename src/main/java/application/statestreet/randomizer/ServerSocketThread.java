package application.statestreet.randomizer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class ServerSocketThread<INPUT,OUTPUT> implements Runnable {
	
	private int portNumber;
	private BlockingQueue<INPUT> inputQueue;
	private BlockingQueue<OUTPUT> outputQueue;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutPutStream;
	private ClientProxy<INPUT,OUTPUT> clientProxy;

	public ServerSocketThread(int portNumber,BlockingQueue<INPUT>inputQueue,BlockingQueue<OUTPUT> outputQueue,ClientProxy<INPUT,OUTPUT> clientProxy) {
		this.portNumber=portNumber;
		this.inputQueue=inputQueue;
		this.outputQueue=outputQueue;
		this.clientProxy=clientProxy;
		
	}

	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			//Waits for Prime Application
			Socket socket = serverSocket.accept();
			try {
				this.dataInputStream = new DataInputStream(socket.getInputStream());
				this.dataOutPutStream = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			while(true) {				
				INPUT input = inputQueue.take();
				OUTPUT result = clientProxy.process(dataOutPutStream, dataInputStream, input);
				try {
					outputQueue.put(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
