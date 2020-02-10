package algos.anagram;

import java.util.HashMap;

// Anagrams are two sentences which contains same characters , in different order

public class Anagram {
	
	public static void main(String args []) {
		
		isAnagram("Mother In Law", "Hitler Woman");
		 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
        
        isAnagram("joy", "enjoy");
 
		
	}
	
	
	
	
	public static void isAnagram(String s1,String s2) {
		
		boolean status=true;
		
//		build a map of chars as key and integers to store count
		
		HashMap<Character,Integer> charcounts = new HashMap<>();
		
		// Get rid of all spaces and change to lower case
		
		String copyOfS1= s1.toLowerCase().replace(" ", "");
		String copyOfS2= s2.toLowerCase().replace(" ", "");
		
		if (copyOfS1.length()!=copyOfS2.length()) {
			//reject if length of sentences are not equal
			status=false;			
		} else {
			char[] s1Array = copyOfS1.toCharArray();
			char[] s2Array = copyOfS2.toCharArray();
			
			for(int i=0;i<s1Array.length;i++) {
				char c = s1Array[i];
				int count=0;
				if(charcounts.containsKey(c)) {
					count = charcounts.get(c);
				}				
				charcounts.put(c, ++count);
			}
			
			for(int i=0;i<s2Array.length;i++) {
				char c = s2Array[i];
				int count=0;
				if(charcounts.containsKey(c)) {
					count = charcounts.get(c);
				}				
				charcounts.put(c, --count);
			}
		}
		
		for(int value:charcounts.values()) {
			if (value!=0) {
				status=false;
			}
		}

		if(status) {
			System.out.println(s1 +" and "+ s2 + " are anagrams");
		} else {
			System.out.println(s1 +" and "+ s2 + " are NOT anagrams");
		}
		
	}

}
