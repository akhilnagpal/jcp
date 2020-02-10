package algos.numberswapping;

public class NumberSwappingWithoutTemp {
	
	public static void main(String args[]) {
		int x=7,y=9;
		
		x=x+y; // x is 16
		y=x-y;  // y is 7
		x=x-y;   // x is 9
		
		System.out.println("X is " + x + "\nY is " + y);
				
	}

}
