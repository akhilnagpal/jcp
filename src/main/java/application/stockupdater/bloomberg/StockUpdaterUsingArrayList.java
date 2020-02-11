package application.stockupdater.bloomberg;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

// Bloomberg Interview

//You would get continuous a stock and the quantity its traded. For example

//apple 100
//
//google 100
//
//MS 250
//
//apple 90

//You need to do print the stocks in the order in which they are most frequently traded
//
//MS 250
//
//apple 190
//
//google 100

 
//PART-B
//How would you change your solution when you need the sorted response one time vs you need to keep this always available for a dashboard

//Use multithreaded version of adding/updating and viewing at the same time

public class StockUpdaterUsingArrayList {
	
	private List<StockQuantity> stockUpdater = new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws Exception {
		StockUpdaterUsingArrayList stockUpdater = new StockUpdaterUsingArrayList();
		Runnable runnable = (() ->  {
			for(int i=0;i<10;i++) {
				stockUpdater.printStockQuantity();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		new Thread(runnable).start();


		stockUpdater.stockUpdate(new StockQuantity(700, "GOOG")); 
		stockUpdater.stockUpdate(new StockQuantity(100, "MSFT")); 
		stockUpdater.stockUpdate(new StockQuantity(500, "APPLE")); 	
		Thread.sleep(1000);
		stockUpdater.stockUpdate(new StockQuantity(500, "MSFT")); 	
		Thread.sleep(1000);
		stockUpdater.stockUpdate(new StockQuantity(500, "MSFT")); 
		Thread.sleep(1000);
		stockUpdater.stockUpdate(new StockQuantity(9000, "APPLE")); 
		Thread.sleep(1000);
		stockUpdater.stockUpdate(new StockQuantity(800, "GOOG")); 

	}
	
	public void stockUpdate(StockQuantity stockQuantity) throws Exception {
		if(stockQuantity==null) {
			throw new Exception();
		}
		int newQuantity=stockQuantity.getQuantity();
		// contains calls equal method in ArrayList, and in equals I classified StockQuantity as by name only
		if(stockUpdater.contains(stockQuantity)) {			
			Optional<StockQuantity> existingOptionalStockQuantity = stockUpdater.stream().filter(name -> name.equals(stockQuantity)).findFirst();
			stockUpdater.remove(existingOptionalStockQuantity.get());
			if(existingOptionalStockQuantity.isPresent()) {		
				StockQuantity existingStockQuantity = existingOptionalStockQuantity.get();
				newQuantity+=existingStockQuantity.getQuantity();
				existingStockQuantity.setQuantity(newQuantity);	
				
				synchronized (stockUpdater) {
					System.out.println("Updating "+stockQuantity);
					stockUpdater.add(existingStockQuantity);
				}
					
			} else {
				throw new Exception("Serious logic error");
			}
		}
		else {
			System.out.println("Adding "+stockQuantity);
			synchronized (stockUpdater) {
				stockUpdater.add(stockQuantity);
			}
		}
	}
	
	public void printStockQuantity() {		
		synchronized (stockUpdater) {
			System.out.println("--------------------------");
			Collections.sort(stockUpdater);
			for(StockQuantity stockQuantity:stockUpdater)
				System.out.println(stockQuantity.getName() + ":" + stockQuantity.getQuantity());
			System.out.println("--------------------------");
		}		
	}

}
