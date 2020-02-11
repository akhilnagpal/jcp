package mocksjunits;

public class Customer {
	
	AccountService accountService;
	
	public boolean process (int i,int j) {
		if(!accountService.check())
			return i+j>2;
		else
			return false;
	}
	
	public void setUp( AccountService accountService) {
		this.accountService=accountService;
	}

}
