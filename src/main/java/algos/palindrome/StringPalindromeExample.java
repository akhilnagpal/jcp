package algos.palindrome;

public class StringPalindromeExample {
	
	// One more way of doing palindrome if to use Stacks and Queues , but that is high level data structures
	//https://www.hackerrank.com/challenges/30-queues-stacks/problem
	
	public static void main(String args[]) {
		
		String wort = "reliefpfpfeiler"; // odd letter
		char[] wortStr = wort.toCharArray();
		System.out.println(wort + " is palindrome :"+checkPalindrome(wortStr));
		
		wort = "paap"; // even letter
		wortStr = wort.toCharArray();
		System.out.println(wort + " is palindrome :"+checkPalindrome(wortStr));
		
		wort = "papa"; // even letter,not a palindrome
		wortStr = wort.toCharArray();
		System.out.println(wort + " is palindrome :"+checkPalindrome(wortStr));
		
		
		
	}
	
	static boolean  checkPalindrome(char[] chrStr) {
		boolean palindrome=true;
		// FIRST CHECK IF PALINDROME IS EVEN NUMBERED OR ODD NUMBERED LETTERS
		if(chrStr.length%2==0) { // for even letter characters in palindrome
			// NOTE HOW MANY ITERATIONS ARE REQUIRED FOR EVEN LETTERS, make it divisible by 2
			for(int i=0;i<chrStr.length/2-1;i++) {
				// YOU COMPARE FROM START and END OF STRING (CHAR ARRAY)
				if(chrStr[i]!=chrStr[chrStr.length-i-1]) {
					return false;
				}
			}
		} else {  // for odd character in palindrome make iteration divisible by 2
			for(int i=0;i<(chrStr.length-1)/2;i++) {
				if(chrStr[i]!=chrStr[chrStr.length-i-1]) {
					return false;
				}
			}
		}
		
		return palindrome;
	}

}
