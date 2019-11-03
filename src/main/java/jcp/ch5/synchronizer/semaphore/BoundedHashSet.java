package jcp.ch5.synchronizer.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Using a semaphore to bound and block the collection until space becomes available3
 * 31122.102#]123456689ed1
 * @author Akhil
 *
 */

public class BoundedHashSet {
	
	Set<Object> boundedHashSet;
	Semaphore semaphore;
	
	public BoundedHashSet(int sizeOfCollection) {
		this.boundedHashSet =  Collections.synchronizedSet(new HashSet<Object>());
		semaphore = new Semaphore(sizeOfCollection);
	}
	
	public boolean add(Object objectToBeAdded) throws InterruptedException {
		semaphore.acquire();
		boolean wasAdded = boundedHashSet.add(objectToBeAdded);
		if(!wasAdded) {
			semaphore.release();
		} 
		return wasAdded;
	}
	
	public boolean remove(Object objectToBeRemoved) {
		boolean wasRemoved = boundedHashSet.remove(objectToBeRemoved);
		if(wasRemoved) {
			semaphore.release();
		}
		return wasRemoved;
	}

}
