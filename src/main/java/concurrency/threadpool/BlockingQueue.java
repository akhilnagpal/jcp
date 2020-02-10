package concurrency.threadpool;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	
	Queue<T> linkedList = new LinkedList<T>();
	private int MAX_SIZE;
	private int EMPTY = 0;
	
	public BlockingQueue(int SIZE) {
		this.MAX_SIZE=SIZE;
	}
	
	public synchronized T dequeue()  {
		if(linkedList.size() == EMPTY) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (linkedList.size() == MAX_SIZE){
			notifyAll();
		}
		return linkedList.poll();
	}
	
	public synchronized void enqueue(T task)  {
		if(linkedList.size()==MAX_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (linkedList.size() == EMPTY){
			notifyAll();
		}
		linkedList.offer(task);
	}

}
