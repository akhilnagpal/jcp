package algos.palindrome;


/*This Java program takes an input number from command line and integer array
* and check if number is palindrome or not. A number is called palindrome
* if number is equal to reverse of number itself. 
* 
* 			313 is a palindrome
* */

// REA THIS EXCERCISE VERYCAREFULLY


public class PalindromeNumberTest {
	
	public static void main(String args[]) {
		
		int[] numbers = {1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11};

		
//		int i =1;
		
//		int j=2%10;
//		
//		System.out.println(j);
		
//		int k = i/10;
//		System.out.println(k);
		
//		int m = reverse(1);
//		System.out.println(m);
		
		for (int p=0;p<numbers.length;p++) {
			System.out.println("number " + numbers[p] + "    "+ isPalindrome(numbers[p]));
		}
		
		
	}
	
	private static boolean isPalindrome(int number) {
        if(number == reverse(number)){
            return true;
        }
        return false;
    }
	
	// BASICALLY REVERSE variable attacks first unit position and extract out the unit from number 
	// and then number is being stripped off recursively
	// 1st iteration unit
	// second iteration - tens
	// third iteration - hundreds
	// This keeps on going until reverse reaches number most significant digit.

	private static int reverse(int number){
        int reverse = 0;
      
        while(number != 0){
          reverse = reverse*10 + number%10; 
          number = number/10;
        }
              
        return reverse;
    }


}
