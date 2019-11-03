package jcp.chapter1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadSafeSequenceGenerator {
  @GuardedBy("this")
  private int value;

  public synchronized int getNext() {
    return value++;
  }

}
