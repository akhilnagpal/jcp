package application.standardchartered.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.mockito.Mock;

import application.standardchartered.Car;
import application.standardchartered.Client;
import application.standardchartered.DbService;
import application.standardchartered.HireService;


public class HireServiceTest {
	
	HireService hireService = new HireService();
	@Mock
	DbService db = mock(DbService.class);
	
	@Test
	public void testMultipleHires() throws InterruptedException, ExecutionException, TimeoutException {
		try {
			hireService.setDb(db);
			when(db.loadFromDb("ConnectionDetails", "select * from clients where clientId = ", Client.class)).thenReturn(null);
			when(db.loadFromDb("ConnectionDetails", "select * from crs where rg = ", Car.class)).thenReturn(new Car("DL65GXR"));
			
			 ExecutorService executorService = Executors.newFixedThreadPool(90);
		        
		    List<Callable<Object>> tasks = new ArrayList<>(12500);
		    for(int i = 0; i < 12500; i++) {
		    	String clientName = "Akhil"+i;
		        tasks.add(() -> hireService.hire(clientName, "DVLA111", "ConnectionDetails", "DL65GXR", "2018-04-04", 4, 12.0));
		       
		    }
		        
		    List<Future<Object>> futures = executorService.invokeAll(tasks);
		    for (Future<Object> future : futures) {
		        Object obj = future.get(100, TimeUnit.MILLISECONDS);
		        System.out.println(obj);
		    }
			
			// HAd to change date because of Sql Date.value of
//			long hireNumber = hireService.hire("Akhil", "DVLA111", "ConnectionDetails", "DL65GXR", "2018-04-04", 4, 12.0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSingleHire() throws InterruptedException, ExecutionException, TimeoutException {
		try {
			hireService.setDb(db);
			when(db.loadFromDb("ConnectionDetails", "select * from clients where clientId = ", Client.class)).thenReturn(null);
			when(db.loadFromDb("ConnectionDetails", "select * from crs where rg = ", Car.class)).thenReturn(new Car("DL65GXR"));
			
			// HAd to change date because of Sql Date.value of
			long hireNumber = hireService.hire("Akhil", "DVLA111", "ConnectionDetails", "DL65GXR", "2018-04-04", 4, 12.0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testLogic( ) {
//		int i = 2015 - Integer.parseInt("20" +"abcd".substring(1, 2));
//		
////		String j = "23333".substring(1,2);
//		
//		System.out.println(i);
//	}

}
