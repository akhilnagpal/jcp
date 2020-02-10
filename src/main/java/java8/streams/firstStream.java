package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class firstStream {
	
	public static void main(String args[]) {
		
		// See I am not iterating over collections and I can simple use declarative functions I used in SQL
		
		List<String>  strings = Arrays.asList("abc","","def");		
		
		//FILTER
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());	
		long count = strings.stream().filter(string -> !string.isEmpty()).count();
		System.out.println(filtered );
		System.out.println(count);		
		
		//MAP -map input to output
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> mapped = numbers.parallelStream().map(n->n*n).collect(Collectors.toList());
		System.out.println(mapped);
		
		//LIMIT - setting upper limit
		List<Integer> mapped2 = numbers.stream().limit(3).collect(Collectors.toList());
		System.out.println(mapped2);
		
		
		//LIMIT and SORT in PIPELINE
		List<Integer> mapped3 = numbers.stream().limit(6).sorted().collect(Collectors.toList());
		System.out.println(mapped3);
	}

}
