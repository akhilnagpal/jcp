package application.standardchartered;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


// this is a simple domain object
// All business functions acting on Car should be off-loaded to HireService
// decouple business functions from Car domain object -loose coupling, you can change business functions later without impacting Car
// Use logger class to log critical errors/warnings in general to a logger file

public class Car {
	// make variables protected/private to use them for inherited classes. if want to extend this in future
	// For thread safety, using public is not recommended
	// also provide setter, getter methods to access. -  this will also do proper validations
	// Perhaps have a generic class say and vehicle and promote generic attributes like hired,age to it.
	// Only keep car specific attributes in this class like make,reg,category
	public String make;
	public String reg;
	public int category;
	public boolean hired;
	public LocalDate hireEnd;
	private int age;
	private long hireNumber;
	
	

	public Car(String reg) {
		// No protection of non-null reg. this looks like a primary key so null must be checked
		this.reg = reg;
	}
	
	// Below constructor never used so does it need to be present

	public Car(String reg, String make, int category) {
		// No protection of non-null reg. this looks like a primary key so null must be checked
		this.make = make;
		this.reg = reg;
		this.category = category;
	}

	public int getAge() {
/*
 * 1.  this looks like a business function so get this in a either in a utility class, which can be shared by other classes in library
   2.  What if reg is null- no protection
   3.  What if reg has not int characters - it will surely throw NumberFormatException
   4.  Why 2015 is hardcoded - what if car age is more tha 2015, age will be in negative, Instead of 2015 - get the current year 
   5.  reg.substring(3, 2) - will throw StringIndexOutOfBoundsException as starting index > end Index 
   */
//		return 2015 - Integer.parseInt("20" +reg.substring(3, 2));
		return 2015 - Integer.parseInt("20" +reg.substring(2, 3));
	}
	
	//* 1.  All business functions acting on Car should be off-loaded to class HireService
	//  Car should have no business persisting to DB. Making things tightly coupled.
	public void hire(DbService dbService, String cd, HireRecord record) throws SQLException {
		hireEnd = record.getStartDate().plusDays(record.getDays());
		hireNumber = record.getHireno();
		// why below line
		Calendar.getInstance();
		dbService.saveToDatabase(this, cd);
	}
	
	//* 1.  All business functions acting on Car should be off-loaded to HireService
	public void release(DbService dbService, String cd) throws SQLException {
		//when this function moved, used car setter methods to set below attributes
		hireNumber = 0;
		hireEnd = null;
		dbService.saveToDatabase(this, cd);
	}
	
	
	// Provide hashcode and equals method implementation 
	// This will enable Car to be used collections like hashmap
	// For hashcode make it from reg 
	
	// Also provide toString () - to give details current state of Car object
	// Very useful in debugging
	
	/*
	 * Why we have this constructed avaliable if not in use
	 * Please delete this - so it does not accidentally called during runtime
	 * This is classical case where code does not complain during compilation, when below constructor called
	 * But this throw Runtime Exception in production/test QA enviornments
	 */
	
		//disabled
		public Car(String make, String reg, int category, boolean hired,Date hireEnd) {
//			this.make = make;
//			this.reg = reg;
//			this.category = category;
//			this.hired = hired;
//			this.hireEnd = hireEnd;
			throw new RuntimeException("disabled full constructor");
		}
}
