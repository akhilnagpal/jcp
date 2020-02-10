package algo.sumofalldivisors;

//The integer 6 is evenly divisible by 1 2 3 and 6 Our divisorSum method should return the sum of these numbers, which is 12 (6+3+2+1)

interface AdvancedArithmetic{
   int divisorSum(int n);
}
public class Solution implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum=1;
        if(n==1) {
            return sum;
        }
        
        if(n%2==0) {
          for (int i=2;i<=n/2;i++) {
              if(n%i==0) {
                  sum+=i;
              }
          }  
        }
        return n+sum;
    }
}

