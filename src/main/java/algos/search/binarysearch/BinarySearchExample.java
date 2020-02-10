package algos.search.binarysearch;

public class BinarySearchExample {
	
	// This works on the sorted Array
	public static void main(String args[]) {
		
		int [] searchArray = {1,5,7,10,45,115,123};
		int key = search(searchArray,0,6,45);
		
		System.out.println(searchArray[key]);
		
	}
	
	static int search(int[] intArray,int low,int high,int value) {
		
		
		int mid=(low+high)/2;
		// Also above operation could have been done by right shift operator, by 1 space means divide by two
		// int mid = (low+high)>>>1
		
		int val = intArray[mid];
		
		if (val>value) {
			high=mid-1;
			return search(intArray,low,high,value);
		} else if (val<value) {
			low=mid+1;
			return search(intArray,low,high,value);
		} else 
			return mid;
		
		
	}

}
