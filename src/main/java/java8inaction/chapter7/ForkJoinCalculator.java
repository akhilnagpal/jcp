package java8inaction.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinCalculator extends RecursiveTask<Long> {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  long[] numbers;
  int start;
  int end;
  int threshold = 10_000;

  public ForkJoinCalculator(long[] numbers) {
    this(numbers, 0, numbers.length);
  }

  private ForkJoinCalculator(long[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    // Base case
    // Calculate length and based on that then split task
    int length = end - start;
    if (length <= threshold) {
      return sequentially(numbers);
    }
    // recursive case
    ForkJoinCalculator leftTask = new ForkJoinCalculator(numbers, start, start + length / 2);
    // below step will be done asynchronously
    leftTask.fork();
    ForkJoinCalculator rightTask = new ForkJoinCalculator(numbers, start + length / 2, end);
    long rightResult = rightTask.compute();
    // Join is a blocking operation
    long leftResult = leftTask.join();
    return leftResult + rightResult;
  }

  private long sequentially(long[] numbers) {
    long sum = 0L;
    for (long number : numbers) {
      sum += number;
    }
    return sum;
  }

  public static void main(String args[]) {
    long[] numbers = LongStream.rangeClosed(0, 100_000_0).toArray();
    ForkJoinTask<Long> forkJoinCalculator = new ForkJoinCalculator(numbers);
    ForkJoinPool pool = new ForkJoinPool();
    Long result = pool.invoke(forkJoinCalculator);
    System.out.println(result);

  }
}
