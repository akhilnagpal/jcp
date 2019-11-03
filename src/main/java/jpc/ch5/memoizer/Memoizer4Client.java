package jpc.ch5.memoizer;

import java.math.BigInteger;

import net.jcip.annotations.ThreadSafe;
@ThreadSafe
public class Memoizer4Client {
	Computable<String, BigInteger>  veryExpensiveFunctionClass = new VeryExpensiveFunctionClass() ;
	
	Memoizer4<String,BigInteger> memoizer4 = new Memoizer4<String,BigInteger>(veryExpensiveFunctionClass);
	
	public void service (String input) {
		BigInteger bigInteger = memoizer4.get(input);
		System.out.println(bigInteger);
		
	}

}
