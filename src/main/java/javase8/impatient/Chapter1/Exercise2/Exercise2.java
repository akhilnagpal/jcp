package javase8.impatient.Chapter1.Exercise2;

import java.io.File;
import java.io.FileFilter;

public class Exercise2 {
	
	public static void main(String args[]) {
		File file = new File("C:\\Users\\Akhil\\Desktop\\---Java interview prepration ----");
		
		//Usual way of doing it before Java 8 - pre lambda
//		File[] files = file.listFiles(new MyFileFilter());
		
		//Replaced FileFilter functional interface with Lambda expression below
		
		File[] filesUsingLamdaExpression = file.listFiles((pathname) -> pathname.isDirectory());
		System.out.println("Now using Lamda Expression" );
		for(File filteredFile : filesUsingLamdaExpression) {
			System.out.println(filteredFile);
		}
		
		// Now with a method expression
		FileFilter myFileFilter = new MyFileFilter();
		
		File[] filesUsingMethodExpression = file.listFiles(myFileFilter::accept);
		System.out.println("Now using Method Expression" );
		for(File filteredFile : filesUsingMethodExpression) {
			System.out.println(filteredFile);
		}
		
		// Using method expression to accept only txt files
		File[] filesUsingMethodExpressionClassStatic = file.listFiles(MyFileFilter::acceptTextFiles);
		System.out.println("Now using Method Expression -Class static" );
		for(File filteredFile : filesUsingMethodExpressionClassStatic) {
			System.out.println(filteredFile);
		}
	}
	

}
