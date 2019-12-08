package algos.memoryleak.staticfield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;

// https://stackify.com/memory-leaks-java/

public class StaticFieldMemoryLeak {

  Random random = new Random();
  private static List<Double> problematciList = new ArrayList<>();

  @Test
  public void test() throws InterruptedException {
    for (int i = 0; i < 10000; i++) {
      problematciList.add(random.nextDouble());
    }

    System.gc();

    Thread.sleep(10000);
  }

}
