package algos.overlaptimeintervals;
/* package whatever; // don't place package name! */

import java.io.*;

import java.util.ArrayList;
import java.util.List;


// Asked in T Rowe price
// Sample Input 
// 12 20 11 23 08 19
// Answer should be 12 19

// First Interval is 12:00 noon to 20:00  in night
// Second interval is 11:00 in morn and 23:00 in night
// Third interval is 08:00 in morn and 19:00 in night
// So overlapping would max of start and min of end
// which is 12:00 - start and 19:00 at end

public class CalculateOverlapTimeIntervals
{
  public static void main (String[] args) throws java.lang.Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] arrayString = input.split(" ");
    
    if(arrayString.length%2 !=0) {
    	System.out.println("Enter input format in start and end time period");
    	return;
    }
    
    int lengthOfIntervals = arrayString.length/2;
    int count=0;
    
    List<Interval> inputIntervals = new ArrayList<Interval>();
    int start=0;
    int end=0;
    for(int j=0;j<lengthOfIntervals;j++) {
    	start=Integer.parseInt(arrayString[count]);
    	end = Integer.parseInt(arrayString[count+1]);
    	
    	Interval interval = new Interval(start,end);
    	inputIntervals.add(interval);
    	count=count+2;
    }
    
//    System.out.println(inputIntervals);
    
    Interval overLapping = getOverlap(inputIntervals);
    
    System.out.println(overLapping.start + " "+overLapping.end);
    
  }
  

   
 

   public static Interval getOverlap(List<Interval> intervalList) {
	    if (intervalList == null) {
	        throw new NullPointerException("Input list cannot be null.");
	    }


	    int maxStart=0;
	    int minEnd=0; 
	    maxStart=0;
	    minEnd=24;

	   
	        for (int j = 0; j < intervalList.size(); j++) {
	            final Interval intervalj = intervalList.get(j);

//	            if (intervalj.start < minEnd && intervalj.end > maxStart ) {
	            	maxStart=Math.max(maxStart,intervalj.start);
	            	minEnd=Math.min(minEnd, intervalj.end);
//	            }
	        }

	    
	    return new Interval(maxStart,minEnd);
	    
	}
}

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e)   {
    start = s; end = e; 
  }
@Override
public String toString() {
	return "Interval [start=" + start + ", end=" + end + "]";
}
 }


	
