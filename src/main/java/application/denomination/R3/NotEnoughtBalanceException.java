package application.denomination.R3;

public class NotEnoughtBalanceException extends Exception {
	
	String message;
	public NotEnoughtBalanceException(String message) {
		this.message=message;
	}
	
	public String getMessage( ) {
		return message;
	}
}
