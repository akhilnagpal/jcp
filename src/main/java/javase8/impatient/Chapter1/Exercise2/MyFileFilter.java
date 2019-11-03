package javase8.impatient.Chapter1.Exercise2;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory()) {
//			System.out.println(pathname + " is a sub-directory" );
			return true;
		}
		return false;
	}
	
	public static boolean acceptTextFiles(File pathname) {
		if(pathname.getName().endsWith(".txt")) {
			return true;
		}
		return false;
	}

}
