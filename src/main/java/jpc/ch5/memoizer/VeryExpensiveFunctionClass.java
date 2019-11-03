package jpc.ch5.memoizer;

import java.math.BigInteger;

public class VeryExpensiveFunctionClass implements Computable<String, BigInteger> {
	@Override
	public BigInteger compute(String arg) {
		//Really Long computation
		return new BigInteger(arg);
	}

}
