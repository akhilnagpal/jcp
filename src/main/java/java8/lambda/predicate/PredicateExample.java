package java8.lambda.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
	
	static Random random = new Random();
	
	// Predicate is a function which take Type T as input and yields boolean
	
	public static void main(String args[]) {		
		playWithPredicates(Arrays.asList(1,2,3,4));
	}
	
	
	public static void playWithPredicates(List<Integer> list) {			
		// You can use below Predicate in other areas too as part of your library
		Predicate<Object> flipCoin = o -> random.nextBoolean();		
		List<Integer> sublist =list.stream().filter(flipCoin).collect(Collectors.toList());		
		System.out.println(sublist);
	}

}
