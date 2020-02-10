package algos.sort.bubblesort;

public class BubbleSortExample {

	public static void main(String[] args) {
		
	
		int[] unsorted = {32, 39,21, 45, 23, 3};
		
		
		
		for(int i=0;i<unsorted.length;i++) {
			System.out.print(unsorted[i]+",");
	    }

		for(int i=0;i<unsorted.length-1;i++) {
			for(int j=1;j<unsorted.length;j++) {
				if(unsorted[j-1]>unsorted[j]) {
					int temp=unsorted[j];
					unsorted[j]=unsorted[j-1];
					unsorted[j-1]=temp;
				}
			}			
			System.out.printf("\nAfter %d pass",i+1);
		
			for(int i1=0;i1<unsorted.length;i1++) {
				System.out.print(unsorted[i1]+",");
		    }
		   
		}
		
		
		
		

	}

}
