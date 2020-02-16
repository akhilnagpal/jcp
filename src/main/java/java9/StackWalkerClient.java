package java9;

public class StackWalkerClient {

	public static void main(String[] args) {
		method1();
	}
	
	static void method4() {
		StackWalker stackWalker  = StackWalker.getInstance();
		stackWalker.forEach(System.out::println);
	}
	
	static void method3() {
		method4();
	}
	
	static void method2() {
		method3();
	}
	
	static void method1() {
		method2();
	}

}
