package algos.string.uniquechars;

import java.util.Arrays;

//Always ask if this string contains ASCII - 128 chars or extended ASCII 256 or UTF

	// below will 
//    1 Will not use additional data structure like boolean array used in other example
//	  2 Will use O(logn) to first sort the array
//    3 O(N) to traverse through array for identical chars nearby

public class UniqueCharsWithoutAdditionalDataStructure {
	
	public static void main(String args[]) {
		System.out.println(checkUniqueness("Akhil"));
		System.out.println(checkUniqueness("Ngpap"));
	}
	
	static boolean  checkUniqueness(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		
		for (int i=1;i<charArray.length;i++) {
			
			if(charArray[i]==charArray[i-1]) {
				return false;
			}
		}
		return true;
	}

}
