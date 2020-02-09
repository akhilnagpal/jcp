#!/usr/bin/java --source 11

/*
How to execute
akhil@AKHIL:~$ ./akhil.sh .
.
./.bash_logout
./.bashrc
./.profile
./.sudo_as_admin_successful
./.viminfo
./akhil.sh
*/

package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {

	public static void main(String[] args) throws IOException {
		Files.walk(Paths.get(args[0])).forEach(System.out::println);
	}

}
