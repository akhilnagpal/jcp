package algos.findconsecutiveones;
import java.util.Scanner;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        String binary = Integer.toBinaryString(n);
        
        System.out.println(binary);
        
        char [] charArray = binary.toCharArray();
        
        int count=0;
        int maxone=0;
        
        for (char t:charArray) {
            if(t=='1') {
                count++;
                if(count>maxone) {
                    maxone=count;
                }
            }
            
            if(t=='0') {
                if(count>maxone) {
                    maxone=count;
                }
                count=0;
            }
        }
        System.out.println(maxone);
    }
}