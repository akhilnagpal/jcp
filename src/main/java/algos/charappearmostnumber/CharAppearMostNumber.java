package algos.charappearmostnumber;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Write a program that finds a character that occurs the most consecutive times, and the number of times it occurs. 
//If there are more than 1 characters (there is a tie) return the first character that appear on the list

public class CharAppearMostNumber {

	public static void main(String[] args) {
		checkCharAppearMostNumber("Akhil Nagpal");
		checkCharAppearMostNumber("ikhil Ngpaalkk");

	}
	
	
	
	public static void checkCharAppearMostNumber(String s) {
		
		// VVVV IMP
		
		//Key to use LinkedHashMap as a data structure is to maintain the insertion order
		// so in case of tie on count it will show the char which appeared first
		
		Map<Character,Integer> charAppearMostNumber = new LinkedHashMap<>();
		
		s=s.toLowerCase();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			int count=0;
			if(charAppearMostNumber.containsKey(c)) {
				count = charAppearMostNumber.get(c);
			}
			
				charAppearMostNumber.put(c, ++count);		
		}
		
		char maxKey = 0;
		int maxValue=0;
		
		Set <Entry<Character,Integer>> check = charAppearMostNumber.entrySet();
		
		for (Entry<Character,Integer> entry:check) {
			if (entry.getValue()>maxValue) {
				maxKey=entry.getKey();
				maxValue=entry.getValue();
			} 
		}
		
		
		
		System.out.println("Character >>"+maxKey + "<< appeared max number of times "+ maxValue);
	}
	

}


