package jpc.ch5.memoizer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2<K,V> {
	
	private Map<K,V> map = new ConcurrentHashMap<>();
	private final Computable<K,V> computable;
	
	public Memoizer2(Computable<K,V> computable) {
		this.computable=computable;
	}
	
	public V get(K key) {
		V value = map.get(key);
		if(value == null) {
			value = computable.compute(key);
			map.put(key, value);
		}
		return value;
	}

}
