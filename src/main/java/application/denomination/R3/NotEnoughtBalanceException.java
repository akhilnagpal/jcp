package application.denomination.R3;

public class NotEnoughtBalanceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public NotEnoughtBalanceException(String message) {
		this.message=message;
	}
	
	public String getMessage( ) {
		return message;
	}
}
