package java8.lambda.predicate;

import java.util.function.Function;

public class CartFunction {
	
	public static Function<Cart, Double> cartValueDouble = cart -> cart.getValue() * 2;
	public static Function<Cart, Double> cartValueTriple = cart -> cart.getValue() * 3;
	public static Function<Cart, Double> cartValueDefault = cart -> cart.getValue() * 1.5;

}
