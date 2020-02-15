package application.r3.codereview;

import java.io.IOException;

public class CodeReviewExamples {
	
	
	public static void main(String args[]) throws IOException {
		PersonDatabaseImpl impl = new PersonDatabaseImpl();
		
		CodeReviewTest test= new CodeReviewTest(impl);
	}

}
