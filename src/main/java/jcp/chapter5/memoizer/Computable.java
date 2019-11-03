package jcp.chapter5.memoizer;

public interface Computable<A,V> {
	
	public V compute(A arg);

}
