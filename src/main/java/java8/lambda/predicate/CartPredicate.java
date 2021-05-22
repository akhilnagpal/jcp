package java8.lambda.predicate;

import java.util.function.Predicate;

public class CartPredicate {
	
	public static Predicate<Cart> cartValueLessThanFive = cart -> cart.getValue() < 5;
	public static Predicate<Cart> cartValueMoreThanOrEqualToFive = cart -> cart.getValue() < 5;

}
