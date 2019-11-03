package jcp.common;

public class ExceptionUtility {
	
	public static void launderThrowable(Throwable cause) {
		if (cause instanceof Error) {
			throw (Error) cause;
		} else if (cause instanceof RuntimeException) {
			throw (RuntimeException) cause;
		} else {
			throw new IllegalStateException("Not checked",cause);
		}
	}
}
