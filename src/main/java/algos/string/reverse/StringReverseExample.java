package algos.string.reverse;

public class StringReverseExample {
	
	
	public static void main (String args[]) {
		String orignalStr= "Sony is going to introduce Internet TV soon";			
		// Iterative method way of reversing Strings
		String reverseString = reverse(orignalStr);			
		System.out.println(reverseString);
		
//		Recursive way of reversing String
		reverseString = reverseRecursively(orignalStr);
		System.out.println(reverseString);
		
	}
	
	public static String reverse(String str) {
		StringBuilder reverseString = new StringBuilder();
		
		char charStr[] = str.toCharArray();

		for(int i=charStr.length-1;i>=0;i--) {
			System.out.println(i);
			reverseString.append(charStr[i]);
		}		
		return reverseString.toString();
	}
	
	public static String reverseRecursively(String str) {
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

}
