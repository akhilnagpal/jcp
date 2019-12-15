package algos.memoryleak.ObjectWithNoHashCode;

import java.util.Map;
import org.junit.Test;

public class ObjectWithNoHashCodeMemoryLeak {

  @Test(expected = OutOfMemoryError.class)
  public void testObjectWithNoHashCodeAndEquals() {
    Map<Object, Object> envMap = System.getProperties();
    while (true) {
      envMap.put(new Key("akhil"), "nagpal");
    }
  }


}
