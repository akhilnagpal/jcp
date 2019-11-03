package jpc.ch5.memoizer;

public interface Computable<A,V> {
	
	public V compute(A arg);

}
