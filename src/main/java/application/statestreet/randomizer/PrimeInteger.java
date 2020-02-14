package application.statestreet.randomizer;

public final class PrimeInteger {
	
	final private int primeNumber;
	final private boolean isPrime;
	
	public int getPrimeNumber() {
		return primeNumber;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public PrimeInteger(int primeNumber, boolean isPrime) {
		super();
		this.primeNumber = primeNumber;
		this.isPrime = isPrime;
	}

}
