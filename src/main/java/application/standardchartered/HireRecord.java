package application.standardchartered;

import java.util.Date;


// Should have a constructor to have validations in one go
// Not Thread safe - as it has setter method and are not final
public class HireRecord {
	private Car car;
	private String client;
	private Date startDate;
	private int days;
	private double rate;
	private int state;
	private long hireno;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getHireno() {
		return hireno;
	}

	public void setHireno(long hireno) {
		this.hireno = hireno;
	}
	
	// instead of using instanceOf override getRate method in respective Bike/Car classes
	// pass the rate argument to getRate of the Vehicle
	// logic should be encapsulated in respective Bike/Car classes 
	public double getRate() {
		// Not thread safe as car is mutable and Race conditions could easily happen
		// if one thread is executing this method and other thread modifies car, which is shared with other thread
			if(car instanceof Bike) return rate;  //no discount for bikes
			return this.rate = car.getAge() > 3 ? rate * 0.9 : rate;  //discount for older cars
//		}
		
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
