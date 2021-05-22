package java8.lambda.predicate;

public class ReplaceIfThenElseWithPredicate {
	
	//https://terricksolo.medium.com/functional-programming-in-java-replace-traditional-if-else-blocks-with-maps-and-streams-8901bac92e5e
	public static void main(String args[]) {
		RuleMatrix ruleMatrix = new RuleMatrix();
		Cart cart1 = new Cart(0.3d);
		System.out.println(ruleMatrix.applyRuleMatrix(cart1).apply(cart1));
		
		Cart cart2 = new Cart(0.6d);
		System.out.println(ruleMatrix.applyRuleMatrix(cart2).apply(cart2));
	}

}
