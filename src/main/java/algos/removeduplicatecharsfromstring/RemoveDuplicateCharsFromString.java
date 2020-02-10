package algos.removeduplicatecharsfromstring;

import java.util.LinkedHashSet;

public class RemoveDuplicateCharsFromString {
	
	public static void main(String args[]) {
		removeDupsCharsFromString("AkhilNagpal");
	}
	
	public static void removeDupsCharsFromString(String s) {
		s = s.toLowerCase();
		
		// Having linkedHashSetis the key as this maintains the insertion order and only stores unique Elements
		LinkedHashSet<Character> chars = new LinkedHashSet<>();
		
		for(int i=0;i<s.length();i++) {
			chars.add(s.charAt(i));
		}
		
		System.out.println(chars);
	}
	
}
