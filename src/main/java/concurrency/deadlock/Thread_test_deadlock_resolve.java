package concurrency.deadlock;

// https://stackoverflow.com/questions/25329332/how-to-fix-this-deadlock-code-in-java

//You need to lock on 2 objects at once (Let's call them A and B). here is a nice explaination of what might happen. 
//To fix that, you could try to always lock in same order:

public class Thread_test_deadlock_resolve {
	
	 public static void main(String[] args) {
	        final Friend alphonse = new Friend("Alphonse");
	        final Friend gaston = new Friend("Gaston");
	        new Thread(new Runnable() {
	            public void run() { alphonse.bow(gaston); }
	        }).start();
	        new Thread(new Runnable() {
	            public void run() { gaston.bow(alphonse); }
	        }).start();
	    }
	
	static class Friend {	
		
	    private static int idCounter;
	    private final int id;
	    private final String name;

	    public Friend(String name) {
	        this.name = name;
	        id = idCounter++;
	    }
	    public String getName() {
	        return this.name;
	    }

	    // Setting the locking order
	    public void bow(Friend bower) {
	        Friend first, second;
	        if(bower.id > id) {
	            first = this;
	            second = bower;
	        } else {
	            first = bower;
	            second = this;
	        }
	        synchronized(first) {
	            synchronized(second) {
	                System.out.format("%s: %s has bowed to me!%n", this.name,bower.getName());

	                bower.bowBack(this);
	            }
	        }
	    }
	    public synchronized void bowBack(Friend bower) {
	        System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
	    }
	}

}
