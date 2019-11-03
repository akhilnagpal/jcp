package interviewcake.recursivestringpermutation;

import java.util.HashSet;
import java.util.Set;

// Permutations - is factorial of number of chars in a word
// For Akhil we will get 5*4*3*2*1 = 120 different combinations

public class RecursiveStringPermutation {

  public static void main(String args[]) {

    Set<String> permutations = getPermutations("Akhil");

  }

  private static Set<String> getPermutations(String string) {

    // base case
    if (string.length() <= 1) {
      Set<String> singleSet = new HashSet<>();
      singleSet.add(string);
      return singleSet;
    }

    String allCharExceptLast = string.substring(0, string.length() - 1);

    String lastChar = string.substring(string.length() - 1, string.length());

    // Start Recursive calling from
    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharExceptLast);

    Set<String> finalPermutations = new HashSet<>();

    for (String permutation : permutationsOfAllCharsExceptLast) {
      for (int index = 0; index <= permutation.length(); index++) {
        String append = permutation.substring(0, index) + lastChar + permutation.substring(index);
        finalPermutations.add(append);
      }
    }

    return finalPermutations;
  }
}
