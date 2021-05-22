package java8.lambda.predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class RuleMatrix {
	
	private Map<Predicate<Cart>,Function<Cart,Double>> ruleMatrix = new HashMap<>();
	
	public RuleMatrix() {
		ruleMatrix.put(CartPredicate.cartValueLessThanFive, CartFunction.cartValueDouble);
		ruleMatrix.put(CartPredicate.cartValueMoreThanOrEqualToFive, CartFunction.cartValueTriple);
	}
	
	public Function<Cart,Double> applyRuleMatrix(Cart cart) {
		return ruleMatrix.entrySet().stream().filter(entry -> entry.getKey().test(cart))
				.map(entry -> entry.getValue()).findFirst().orElse(CartFunction.cartValueDefault);		
	}

}
