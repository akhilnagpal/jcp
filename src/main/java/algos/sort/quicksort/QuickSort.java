package algos.sort.quicksort;

import java.util.Arrays;

//refer to Quick Sorting at Algorithms and data structure notes
// find the Big O for time and space wise ???
public class QuickSort {
	
	private static  void quickSort(int array[],int lowest,int highest) {
		if(lowest>highest) {
			return;
		}
		
		if(array==null | array.length==0 ) {
			return;
		}
		
		int i=lowest;
		int j=highest;
		
		int middle = lowest+(highest-lowest)/2;
		int pivot = array[middle];
		
		while(i<=j) {
			
			while(array[i]<pivot) {
				i++;
			}
			
			while(array[j]>pivot) {
				j--;
			}
			
			if(i<=j) {
				swapElements(array,i,j);
				i++;
				j--;
			}			
		} // end of while loop
		
		if (lowest < j)
        {
            quickSort(array, lowest, j);
        }
		
		if (highest > i)
        {
            quickSort(array, i, highest);
        }
	}
	
	private static void swapElements(int array[], int first, int second) {
		int temp = array[first];
		array[first]=array[second];
		array[second]=temp;		
	}

	public static void main(String[] args) {
		int unsortedArray[] = {121,5,23,6,29,78,54};
		quickSort(unsortedArray,0,unsortedArray.length-1);
		System.out.print(Arrays.toString(unsortedArray));
		
	}

}
