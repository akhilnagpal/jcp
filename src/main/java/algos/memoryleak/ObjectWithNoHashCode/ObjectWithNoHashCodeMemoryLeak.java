package algos.memoryleak.ObjectWithNoHashCode;

import java.util.Map;


public class ObjectWithNoHashCodeMemoryLeak {

//  @Test(expected = OutOfMemoryError.class)
  public void testObjectWithNoHashCodeAndEquals() {
    Map<Object, Object> envMap = System.getProperties();
    while (true) {
      envMap.put(new Key("akhil"), "nagpal");
    }
  }


}
