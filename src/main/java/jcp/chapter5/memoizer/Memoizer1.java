package jcp.chapter5.memoizer;

import java.util.HashMap;
import java.util.Map;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Memoizer1<K, V> {

  private Computable<K, V> computable;
  @GuardedBy("this")
  private Map<K, V> map = new HashMap<K, V>();

  public Memoizer1(Computable<K, V> computable) {
    this.computable = computable;
  }

  public synchronized V get(K key) {
    V value = map.get(key);
    if (value == null) {
      value = computable.compute(key);
      map.put(key, value);
    }
    return value;
  }

}
