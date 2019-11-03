package javase8.impatient.Chapter1.Exercise11;

public interface J {
	void abstract_f();
	
	default void  default_method_f() {
		System.out.println("default_method_f of Interface J");		
	}
	
	static void  static_method_f() {
		System.out.println("static_method_f of Interface J");
	}
	
	default void  default_another_method_f() {
		System.out.println("default_method_f of Interface J");		
	}
}
