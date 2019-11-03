package javase8.impatient.Chapter1.Exercise11;

public class Exercise11 implements I,J {
	
	public static void main(String args[]) {
		
		Exercise11 exercise11 = new Exercise11();
		exercise11.default_method_f();
		exercise11.access_static_method_f();
		
		I interfaceI= exercise11;
		interfaceI.abstract_f();
		exercise11.default_method_f();
		exercise11.access_static_method_f();
		
	}

	
	// You do not need to specify which abstractf of interface it is implementing at this time
	// abstractf is present in both Interface I and J
	@Override
	public void abstract_f() {
		// TODO Auto-generated method stub
		System.out.println("Calling common code");
	}

	@Override
	public void default_method_f() {
		// You do need to specify which interfaces's default method you need to use.
		// Both Interfaces I and J have default_method_f
		J.super.default_method_f();
		
	}
	
	
	
	public void access_static_method_f() {
		// You do need to specify which interfaces's default method you need to use.
		// Both Interfaces I and J have default_method_f
		J.static_method_f();
		
	}

	// Very Important concept - we have name collisions with other interface J even if this below method is not default in interface I
	@Override
	public void default_another_method_f() {
		// TODO Auto-generated method stub
		
	}
}
