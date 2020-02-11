package concurrency.weakreference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import concurrency.doublecheckingsingleton.SingletonDoubleChecking;

public class WeakReferenceExample {
	public static void main (String args[]) {
		// below now will be strong reference of SingletonDoubleChecking
		SingletonDoubleChecking singletonDoubleCheckingStrongReference = SingletonDoubleChecking.getInstance();
		
		// Weak Reference typically used for a Map where we do not want to hold key information of a class object
		// if that class object itself became null later. See below example
//		https://stackoverflow.com/questions/299659/whats-the-difference-between-softreference-and-weakreference-in-java
		// 		WeakHashMap<Employee, EmployeeVal> aMap = new WeakHashMap<Employee, EmployeeVal>();
		//		Employee emp = new Employee("Vinoth");
		//		EmployeeVal val = new EmployeeVal("Programmer");
		//		aMap.put(emp, val);
		//		emp = null;
		// The Map holding the key makes no sense here as it is null, so the reference if emp in weakhashmap will be cleared too
		// In case of StrongMap (Usual HashMap), this null reference will still be held. memory leak
		WeakReference <SingletonDoubleChecking> singletonDoubleCheckingWeakReference = new WeakReference<>(singletonDoubleCheckingStrongReference);
		// below now will be weak reference of SingletonDoubleChecking
		@SuppressWarnings("unused")
		SingletonDoubleChecking weakReferenceSingletonDoubleChecking = singletonDoubleCheckingWeakReference.get();
		
		// Soft references are less eager to be collected by GC.
		// It can survive few GC cycles as long as memory supply is plentiful
		// It is an excellent choice for cache (storing image), to let GC know that unlike strong reference
		// if memory is in short supply collect from cache and program can rebuilt later.
		// It is guaranteed that soft references are cleared before OOM isthrown
		SoftReference <SingletonDoubleChecking> singletonDoubleCheckingSoftReference = new SoftReference<>(singletonDoubleCheckingStrongReference);
		// below now will be soft reference of SingletonDoubleChecking
		@SuppressWarnings("unused")
		SingletonDoubleChecking softReferenceSingletonDoubleChecking = singletonDoubleCheckingSoftReference.get();
		
	}

}
