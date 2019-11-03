package javase8.impatient.Chapter1.Exercise4;

import java.io.File;
import java.util.Arrays;

public class Exercise4 {

	public static void main(String[] args) {
		
		
		File directory = new File("C:\\Users\\Akhil\\Desktop\\---Java interview prepration ----");
		File[] files = directory.listFiles();
		
		// We need to bring directories first and hence we need to make directories smaller than file for return (return -1)
		Arrays.sort(files,(file1,file2) -> {
			// file1 will come first
			if(file1.isDirectory() && !file2.isDirectory()) {
				return -1;
			}
			
			if(!file1.isDirectory() && file2.isDirectory()) {
				return 1;
			}
			// if both directories or files then do simple comparison on file/directories names
			return file1.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
			
		});
		
		for(File file:files) {
			System.out.println(file);
		}

	}
	
	

	
	

}
