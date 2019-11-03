package javase8.impatient.Chapter1.Exercise11;

// If both Superclass and I have common abstract method , there is not problem

// If both Superclass and I have common default method then class do need to explictily override this 
// in its own body as this is already implemented by the Superclass
// If you need interface implementation you can either call this explictily in one of the methods.

public class Exercise11part2 extends SuperClass implements I {

	@Override
	public void abstract_f() {
		// TODO Auto-generated method stub
		
	}
	
	public void fetch_default_method_f_of_Interface_I() {
		I.super.default_method_f();
		
	}

	public static void main(String args[] ) {
		new Exercise11part2().default_method_f();
		new Exercise11part2().fetch_default_method_f_of_Interface_I();
	}

	@Override
	public void default_another_method_f() {
		// TODO Auto-generated method stub
		
	}

}
