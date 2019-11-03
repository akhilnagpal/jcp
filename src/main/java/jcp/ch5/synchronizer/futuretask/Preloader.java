package jcp.ch5.synchronizer.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import jcp.common.DataLoadException;
import jcp.common.ExceptionUtility;
import jcp.common.ProductInfo;

public class Preloader {
	
	private FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {

		public ProductInfo call() throws DataLoadException {	
			//loading from the database
			return new ProductInfo();
		}		
	});
	
	
	private Thread thread = new Thread(future);
	
	public void start() {
		thread.start();
	}
	
	public ProductInfo get() throws DataLoadException {
		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			Throwable throwable =e.getCause();
			if(throwable instanceof DataLoadException) {
				throw (DataLoadException) throwable;
			} else {
				ExceptionUtility.launderThrowable(throwable);
			}
		}
		return null;
	}

}
