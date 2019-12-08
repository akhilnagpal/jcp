package algos.memoryleak.staticfield;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;

// https://stackify.com/memory-leaks-java/

public class NoStaticMemoryFieldLeak {

  Random random = new Random();

  @Test
  public void givenNormalFieldWhenLotsOfOperationsThenGCWorksFine() throws InterruptedException {
    addElementsToTheList();
    System.gc();
    Thread.sleep(30000); // to allow GC do its job
  }

  private void addElementsToTheList() {
    ArrayList<Double> list = new ArrayList<>(1000000);
    for (int i = 0; i < 1000000; i++) {
      list.add(random.nextDouble());
    }
  }

}
