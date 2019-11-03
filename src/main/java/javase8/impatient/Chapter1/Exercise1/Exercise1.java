package javase8.impatient.Chapter1.Exercise1;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise1 {
	
	static Comparator<String> comp= (first,second) ->  {
		System.out.println("Comparator Thread :-" + Thread.currentThread().getName() );
		return Integer.compare(first.length(), second.length());
	};

	public static void main(String[] args) {
		
		System.out.println("Main Thread :-" + Thread.currentThread().getName() );
		
		String words[] = {"Akhil", "rt", "Nagpal"};
		
		System.out.println("Before Sorting  \n");
		
		printArray(words);		
		
		Arrays.sort(words,comp);
		
		System.out.println("After Sorting  \n");
		
		printArray(words);

	}

	private static void printArray(String[] words) {
		for (String word:words) {
			System.out.println(word);
		}
	}

}
