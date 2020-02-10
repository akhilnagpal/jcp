package concurrency.doublecheckingsingleton;

public class SingletonDoubleChecking {

	volatile static SingletonDoubleChecking _instance=null;
	
	public static SingletonDoubleChecking getInstance () {
		if(_instance==null) {   // First check
			synchronized(_instance) {
				// second check - to again check if the thread holding lock can see null again. This is important,
				// as previously held thread having lock too could have initialized this.
				if(_instance==null) {  											
					_instance= new SingletonDoubleChecking();
				}
			}
		}
		return _instance;
	}
	
	
}



