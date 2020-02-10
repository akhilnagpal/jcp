package algos.sort.sortedmerge;


// Gayle Lakmman Pg 309 - merge two sorted arrays
public class SortedMerge {
	
	public void mergeSortedArrays(int a[],int b[],int lastA,int lastB) {
		int indexofB = lastB-1;
		int indexofA = lastA-1;
		
		
		int indexMerged=lastB+lastA-1;
		
		if (indexofB>=0) {
			if (a[indexofA]>=0 && a[indexofA] > b[indexofB])
			{
				a[indexMerged]=a[indexofA];
				indexofA--;				
			} else {
				a[indexMerged]=b[indexofB];
				indexofB--;
			}
			indexMerged--;
		}
	}
	


}
