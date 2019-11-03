package algos.dynamicprogramming.fibonacci;

// Algorthm
// f(n) = 0 for n=0
// = 1 for n=1
// = f(n-1) + f(n-2) for n >1
public class Fibonacci {

  private static final String D_IN_D_MICROSECONDS_N = " %d in %d microseconds %n";

  public static void main(String args[]) {
    int fibon = 40;
    long start = System.nanoTime();
    int result = fibonnaciWithoutMemoziation(fibon);
    long stop = System.nanoTime();
    System.out.printf(D_IN_D_MICROSECONDS_N, result, (stop - start) / 1000);

    start = System.nanoTime();
    result = fibonnaciWithMemoziationBottomUp(fibon);
    stop = System.nanoTime();
    System.out.printf(D_IN_D_MICROSECONDS_N, result, (stop - start) / 1000);


    // Best Algo
    start = System.nanoTime();
    result = fibonnaciWithMemoziationStoringLastTwo(fibon);
    stop = System.nanoTime();
    System.out.printf(D_IN_D_MICROSECONDS_N, result, (stop - start) / 1000);

    start = System.nanoTime();
    result = fibonnaciWithMemoziationTopDown(fibon);
    stop = System.nanoTime();
    System.out.printf(" %d in %d microseconds", result, (stop - start) / 1000);
  }

  // Really bad performance if memoization not used for big numbers.
  // Stack overflow likely to be encountered without memoziation

  private static int fibonnaciWithoutMemoziation(int n) {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else {
      return fibonnaciWithoutMemoziation(n - 1) + fibonnaciWithoutMemoziation(n - 2);
    }
  }

  // We start with lower values, and store them, and start building the solution for higher values
  // Time Complexity O(n) - going through all, Space complexity O(n) - for maintaining array
  private static int fibonnaciWithMemoziationBottomUp(int n) {
    int fib[] = new int[n + 1];
    fib[0] = fib[1] = 1;
    for (int i = 2; i < n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    return fib[n - 1];
  }

  // We start with lower values, and store them, and start building the solution for higher values
  // Time Complexity O(n) - going through all, Space complexity O(1) - for only storing last two.
  private static int fibonnaciWithMemoziationStoringLastTwo(int n) {
    int a = 0, b = 1, sum = 0;
    for (int i = 0; i < n - 1; i++) {
      sum = a + b;
      a = b;
      b = sum;
    }
    return sum;
  }


  // still use recursion but use calculated values if already calculated before
  private static int fibonnaciWithMemoziationTopDown(int n) {
    int fib[] = new int[n + 1];
    return helper(n, fib);
  }

  private static int helper(int n, int[] fib) {
    if (n == 1 || n == 2)
      return 1;
    if (fib[n] != 0)
      return fib[n];
    return fib[n] = helper(n - 1, fib) + helper(n - 2, fib);
  }
}
