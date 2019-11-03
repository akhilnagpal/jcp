package javase8.impatient.Chapter1.Exercise3;

import java.io.File;

public class Exercise3 {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\Akhil\\Desktop\\---Java interview prepration ----");
		
		// 
		String extension = ".txt";
		
		// extension is the free variable for below lamda expression, derived from enclosing scope
		File[] files = directory.listFiles(pathname -> pathname.getName().endsWith(extension));
		
		for (File file:files) {
			System.out.println(file.getName());
		}
		

	}

}
