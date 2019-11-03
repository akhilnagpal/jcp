package jcp.chapter5.memoizer;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import jcp.common.ExceptionUtility;

public class Memoizer3<K,V> {
	
	private Map<K,Future<V>> map = new ConcurrentHashMap<>();
	private Computable<K,V> computable;
	
	public Memoizer3(Computable<K,V> computable) {
		this.computable=computable;
	}
	
	public V get(K key) {
		Future<V> future= map.get(key);
		if(future==null) {			
			Callable<V> callableTask = new Callable<V>() {
				@Override
				public V call() throws Exception {
					// TODO Auto-generated method stub
					return computable.compute(key);
				}				
			};
			
			FutureTask<V> f = new FutureTask<V>(callableTask);
			future=f;
			map.put(key, f);
			f.run();
		}
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			ExceptionUtility.launderThrowable(e.getCause());
		} finally {
			
		}
		return null;
		
	}

}
