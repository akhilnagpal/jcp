//#!/usr/bin/java --source 11

package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// How to run - Now you can directly run from command line using java command
// C:\Users\Akhil\git\jcp\src\main\java>java java11/ListFiles.java ./java11

public class ListFiles {

	public static void main(String[] args) throws IOException {
		Files.walk(Paths.get(args[0])).forEach(System.out::println);
	}

}
