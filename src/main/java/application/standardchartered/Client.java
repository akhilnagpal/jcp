package application.standardchartered;

import java.util.Vector;

public class Client {
	private String name;
	//make licenseNumber private
	String licenseNumber;
	private String cd;
	// Use Arraylist as it is faster than Vector
	// You can always guard with ThreadSafety of records using synchronized
	@SuppressWarnings("rawtypes")
	private Vector records;
	
	public Client(String name, String licenseNumber, String cd) {
		// Do non-null validations and throw error
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getCd() {
		return cd;
	}

	@SuppressWarnings("rawtypes")
	public Vector getRecords() {
		return records;
	}
	
	//Correct the spelling of method, it should be intuitive
	@SuppressWarnings("rawtypes")
	public void addHirerecrd(HireRecord r) {
		if(records == null) {
			records = new Vector();
		}
		records.add(r);
	}
	
	// Provide hashcode and equals method implementation 
		// This will enable Client to be used collections like hashmap
		// For hashcode make it from name/licensenumber 
		

	// Why not to add cd in the toString
	@Override
	public String toString() {
		return name + licenseNumber;
	}
	
}
