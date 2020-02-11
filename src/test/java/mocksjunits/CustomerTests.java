package mocksjunits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;



public class CustomerTests  {
	
	@Mock
	AccountService accountService = mock(AccountService.class);
	Customer customer;
	
	@Before
	public void before () throws Exception {
		customer=new Customer();
		System.out.println("Setting it up!");
	}

	@Test
	public void testProcess() {
		System.out.println("Running testProcess");
		customer=new Customer();
		customer.setUp(accountService);
		when(accountService.check()).thenReturn(false);
		assertTrue(customer.process(2, 3));
		verify(accountService).check();
	}
	
	@After
	protected void tearDown() {
		
	}

}
