package algos.string.uniquechars;

public class UniquCharsExample {
	
	// Always ask if this string contains ASCII - 128 chars or extended ASCII 256 or UTF
	
	// below will take o(N) MAX as we are going through each element
	
	public static void main(String args[]) {
		System.out.println(checkUniqueness("Akhil"));
		System.out.println(checkUniqueness("Nagpal"));
	}
	
	static boolean  checkUniqueness(String s) {
		
		if (s.length()>128) {
			return false;
		}
		
		boolean[] char_set = new boolean[128];
		
		for (int i=0;i<s.length();i++) {
			char val = s.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val]=true;
			
		}
		return true;
	}

}
