package algos.parenthismatchup;

import java.util.Stack;

public class ParenthisisMatchupExample {
	
	public static void main(String args[]) {
		System.out.println(parenthismatchUp("()"));
		
		System.out.println(parenthismatchUp("(123)"));
	}
	
	static boolean parenthismatchUp(String string) {
		Stack<Character> stack =new Stack<>();
		char[] charArray = string.toCharArray();
		
		for(int i=0;i<charArray.length;i++) {
			char c= charArray[i];
			
			if(c == '(' ) {
				stack.push(c);
			} else if (c==')') {
				if(stack.peek()=='(') {
					stack.pop();
				}					
				else
					return false;
			}
		}
		
		
		return stack.isEmpty();
	}
}
