package jpc.ch5.memoizer;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import jcp.common.ExceptionUtility;

/**
 * This cache is the most efficient cache (from memoizer3) where if one thread is computing the value it will communicate with other
 * threads thats future is getting calculated and they simply need to wait (block) from future.get
 * @author Akhil
 *
 * @param <K>
 * @param <V>
 */
public class Memoizer4<K,V> {
	
	private Map<K,Future<V>> map = new ConcurrentHashMap<>();
	private Computable<K,V> computable;
	
	public Memoizer4(Computable<K,V> computable) {
		this.computable=computable;
	}
	
	public V get(K key) {
		Future<V> future = map.get(key);
		
		Callable<V> callable = new Callable<V>() {

			@Override
			public V call() throws Exception {
				// TODO Auto-generated method stub
				return computable.compute(key);
			}
		};
		
		FutureTask<V> futureTask = new FutureTask<>(callable);
		Future<V> returnValue = map.putIfAbsent(key, futureTask);
		if(returnValue==null) {
			future=futureTask;
			futureTask.run();
		}
		
		try {
			future.get();
		} catch (CancellationException e) {
			map.remove(key);			
		}
		catch (InterruptedException | ExecutionException e) {
			
			ExceptionUtility.launderThrowable(e.getCause());
		}	
		return null;
	}

}
