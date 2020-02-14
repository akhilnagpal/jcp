package application.standardchartered;

import java.sql.Date;
import java.sql.SQLException;

// Why no test cases has been written for any classes
// Mock the DBService and make sure every method is unit tested
// Have HireServiceTest and other classes containing business logic

/*
 * Main hire service class
 */
public class HireService {
	
	// this should be final as likely to be accessed by many threads, below can be mutated
	// Db service would be shared by multiple threads
	// make Dbservice local or synchrmonizrd if shared by a threads
	private DbService db;
	
	// Have a HashMap of clients and cars.
	// which can store cars and clients already fetched by DB once
	
	//called by rest servlet to make booking
	public long hire(String name, String licenseNumber, String cd, String reg, String start, int days, double rate) throws SQLException {
		boolean hired = false;
		// local variable client - this is good as each thread will have it's own copy- no intereference
		Client client = getClient(name, licenseNumber, cd);
		Car car = getCarDetails(reg, cd);
		
		// use car.isHired() - instead of using hired attribute directly
		if(car == null || car.hired) {
			return -1;
		}
		
		// Not guranteed to have unique id in multi-threaded enviornment,
		// use a java.util.UUID
		long hireNumber = System.nanoTime(); //use as unique id
		HireRecord hire = new HireRecord();
		client.addHirerecrd(hire);
		hire.setCar(car); hire.setDays(days);
		hire.setClient(client.getName());
		// Instead of SQL.Date.valueOf - use java8 LocalDateTime
//		String str = "1986-04-08 12:30";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		hire.setStartDate(Date.valueOf(start));
		hire.setRate(rate); hire.setState(1);
		hire.setHireno(hireNumber);
		hire.setDays(days);	
		
		//never tested
//		double check = hire.getRate();
		

		
		// Client saving to DB should be in same transaction boundary as saving car hiring. so per thread for any SQL exception
		// we have to manually rollback - calling delete on dbservice
		// client database save car hire DB, to protect from creating invalid records in case off issue during car hire.
		// only commit once both client and car details are saved.
		db.saveToDatabase(client, cd);
		//the hire method do not belong to Car, instead it should be present in this class.
		car.hire(db, cd, hire);
		// update car/client in internal memory
		// commit the transaction per thread
		return hireNumber;
	}
	
	public void markReturned(String cd, long hireno)  {
		try {
			//loadCar from internal memory , no need to hit DB if Car is present in internal memory
			Car car = (Car) db.loadFromDb(cd, "select * from crs where hrrnm = " + hireno, Car.class);
			// This method should not belong to car, instead it shouldbe done here
			car.release(db, cd);
		} catch (SQLException e) {
			//nothing we can do
			// throw SQLException or encapsulate in User checked Exception that narkReturned failed
		}
		// update car in internal memory after release
	}
	
	public Car getCarDetails(String rg, String cd)  {
				// store Car in a internal concurent hashmap, after creation, so need to keep on querying DB
				// DB resources are expensive, and fetching from DB has latency
				// Instead once got from DB , Car details should be present in memory (ConcurrentHashMap) <Reg,Car>
		try {
			// What if Car does not exist
			// if car does not exist create Car object, like done in getClient
			// RESTORE BELOW LINE
			// Again db is shared among multiple threads, could result in deadlock or race conditions
			return (Car) db.loadFromDb(cd, "select * from crs where rg = " + rg,Car.class);
			
		} catch (SQLException e) {
			// Do not create Car object like this. Catch block are supposed to handle exception not writing creating objects
			// you can create car in finally or outside of try/catch/finally
			return new Car(rg);
		}
	}
	
	// If do not use then delete it.	
	//dont use	
	private DbService getDb() {
		return db;
	}
	
	
	public void setDb(DbService db) {
		this.db = db;
	}
	
	// throw SQL exception back as it is using DB
	public Client getClient(String name, String licenseNumber, String cd)  {
		Client client;
		// store client in a internal hashmap, after creation, so need to keep on querying DB
		// DB resources are expensibe, and fetching from DB has latency
		// Instead once got from DB , client details should be present in memory
		try {
			// Need to guard this db (I/O) resource, as it is shared among multiple threads
//			   Connections can't be shared between threads because each connection is also a transaction.
			// , could result in deadlock or race conditions when thread acquiring connections
			// either to synchrnonize db service or make connection pools and every thread fetches a connection and thread needs to wait 
			// if no connections are available
			client = (Client) db.loadFromDb(cd, "select * from clients where clientId = " + name,Client.class);
			// never catch generic Exception
			// Instead catch specific excption like SQL Exception in this case
		} catch (Exception e1) {
			// why unchecked exception is being thrown, and the exception thrown by DB, instead log and throw back checked exception 
			throw new RuntimeException();
		}
		
		if(client == null) {
			client = new Client(name,licenseNumber,cd);
			try {
				// we can avoid saving client now, this should be later, when hire process is completed.
				// this also means we preserve transaction if any exceptions thrown later
				// so all saves/updates to DB at one place with each thread having access to own db connection
				db.saveToDatabase(client, cd);
				// never catch generic Exception
				// Instead catch specific excption like SQL Exception in this case
			} catch (Exception e) {
				// never do printstackTrace, throw back to calling method and let the caller decide it
				// or create checked Exception, which can then be handled by client
				e.printStackTrace();
			}
		}
		
		return client;
	}
}
