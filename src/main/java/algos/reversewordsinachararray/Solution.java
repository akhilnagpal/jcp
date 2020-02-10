package algos.reversewordsinachararray;

public class Solution {

//    private static final Scanner scanner = new Scanner(System.in);
    
    static char[] reversewords(char[] words) {
    	
    	int count=0;
    	
    	
    	for(char element:words) {
    		if(element==' ') {
    			count++;
    		}
    	}
    	
    	String wordsof[] = new String[count];
    	StringBuilder wordbuilder = new StringBuilder();
    	int counter=0;
    	int sizer=0;
    	for(char element:words) {
    		if(element!=' ') {
    			wordbuilder.append(element);
    			if(sizer==words.length-1) {
    				wordsof[counter] = wordbuilder.toString();
    				break;
    			}
    		} else {
    			wordbuilder.append(element);
    			wordsof[counter] = wordbuilder.toString();
    			counter++;
    			wordbuilder = new StringBuilder();
    		}
    		sizer++;
    	}
    	
    	char[] reverse = new char[words.length];
    	
    	int m=0;
    	
    	for(int i=wordsof.length-1;i>=0;i--) {
    		String word= wordsof[i];
    		char [] wordArray = word.toCharArray();
    		for(char wordElement:wordArray) {
    			reverse[m]=wordElement;
    			m++;
    		}
    	} 
    	
    	return reverse;
    	
    }

    public static void main(String[] args) {
    	
    	  char[] words = {'p','r','a','c',' ', 'm','a','k','e',' ','p','e','r','f','e','c','t',' '};
    	  System.out.println(reversewords(words));
    	
    	
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        scanner.close();
//
//        String binary = Integer.toBinaryString(n);
//        
//        System.out.println(binary);
//        
//        char [] charArray = binary.toCharArray();
//        
//        int count=0;
//        int maxone=0;
//        
//        for (char t:charArray) {
//            if(t=='1') {
//                count++;
//                if(count>maxone) {
//                    maxone=count;
//                }
//            }
//            
//            if(t=='0') {
//                if(count>maxone) {
//                    maxone=count;
//                }
//                count=0;
//            }
//        }
//        System.out.println(maxone);
    }
}