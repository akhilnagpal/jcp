package java9;

import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerClient {
	static StackWalker stackWalkerSpecific;
	static List<Integer> lines;

	public static void main(String[] args) {
		//Showing forEach --> to show all stack traces
		method1();
		System.out.println("***************************");
		//Showing Walk to show restricted stackTrace
		stackWalkerSpecific  = StackWalker.getInstance();
		method6();
	}
	
	static void method6() {
		method5();		
	}
	
	static void method5() {
		lines = stackWalkerSpecific.walk(stackFrameStream-> stackFrameStream.filter(stackFrame->stackFrame.getMethodName().contains("method6"))
				.map(stackFrame->stackFrame.getLineNumber()).collect(Collectors.toList()));
		lines.forEach(System.out::println);
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
