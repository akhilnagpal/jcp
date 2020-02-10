package algos.array.findduplicates;

import java.util.HashSet;

// I have done various approaches
// this can be extended to String array too

public class FindDuplicatesExample {
	public static void main(String args[]) {
		
		int[] array1 = {1,78,56,67,77,67};
		System.out.println(findDuplicatesHashSetWay(array1));
		System.out.println(findDuplicatesBruteForce(array1));
		System.out.println(findDuplicatesOnlyForIntegerArrayUsingFormula(array1));
		
	}
	
	// this one is better than brute force as it uses o(n)
	
	static int findDuplicatesHashSetWay(int[] array) {
		
		HashSet<Integer> hashSet = new  HashSet<>();
		for (int i: array) {
			if(!hashSet.add(i)) {
				return i;
			}
		}
		return -1;
	}
	
	// below one is inefficient than above as it has o(n square)
	static int findDuplicatesBruteForce(int[] array) {
		
		for (int i=0;i<array.length;i++) {
			for(int j=1;j<array.length;j++) {
				if(i!=j && array[i]==array[j] ) {
					return array[i];
				}
			}
			
		}
		
		return -1;
		
	}
	
	// below one is inefficient than above as it has o(n square)
		static int findDuplicatesOnlyForIntegerArrayUsingFormula(int[] array) {
			int sum=0;
			for (int i=0;i<array.length;i++) {				
				sum+=array[i];
			}
			
			int n = array.length;
			int formula = n*(n+1/2);
			
			return formula-sum;
			
		}
}
