package algos.pangram;
import java.util.HashSet;
import java.util.Set;

public class Pangram {

    private final Set<Character> lettersRemaining = new HashSet<>();

    public Pangram(String s) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            lettersRemaining.add(ch);
        }
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            lettersRemaining.remove(s.charAt(i));
        }
    }

    public boolean isPangram() {
        return lettersRemaining.isEmpty();
    }

    public Set<Character> getMissingAlphabets() {
//    	Iterator<Character> itr = lettersRemaining.iterator();
//        while(itr.hasNext()){
//            System.out.println(" Iterating over HashSet in Java current object: " + itr.next().toString());
//        }
    	lettersRemaining.stream().forEach(System.out::println);
    	
        return new HashSet<>(lettersRemaining);
    }
}
