package java8inaction.chapter7;

import java.util.stream.LongStream;

public class Chapter7Client {

  public static void main(String[] args) {


    long fastest = Long.MAX_VALUE;

    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      sequntialStream(100000000L);
      long duration = (System.nanoTime() - start) / 1000000;
      if (duration < fastest)
        fastest = duration;
    }
    System.out.println("Sequential stream on LongStream is " + fastest + " msecs");

    fastest = Long.MAX_VALUE;
    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      parallelStream(100000000L);
      long duration = (System.nanoTime() - start) / 1000000;
      if (duration < fastest)
        fastest = duration;
    }
    System.out.println("Parallel stream on LongStream is " + fastest + " msecs");


  }

  public static long sequntialStream(long n) {
    return LongStream.rangeClosed(1L, n).reduce(0L, Long::sum);
  }

  public static long parallelStream(long n) {
    return LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum);
  }

}
