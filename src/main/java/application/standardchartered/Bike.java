package application.standardchartered;

/*
 * Andyr request want to hire bikes too 
 */
// Bike is not car so cannot extend like this.
// Instead derive from generic vehicle as suggested in Car domain objects review comments


public class Bike extends Car {
	
	// provide getter and setter
	// This looks like a mandatory argument so should be in constructor
	public int cc;
	
	//provide 

	public Bike(String reg) {
		super(reg);
	}
	
	// Provide hashcode and equals method implementation 
		// This will enable Bike to be used collections like hashmap
		// For hashcode make it from cc and reg attribute
		
		// Also provide toString () - to give details current state of Car object
		// Very useful in debugging
	
}
