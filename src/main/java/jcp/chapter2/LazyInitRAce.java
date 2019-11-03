package jcp.chapter2;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRAce {
  private ExpensiveObject instance = null;

  public ExpensiveObject getInstance() {
    if (instance == null) { // at this time if thread A alread in the process of initlising Expesive
                            // Object
      // But still has not written back, then thread B will initilise new Expesive Object
      instance = new ExpensiveObject();
      // Thread A and B might return two different instances from heap to the caller.
      // Above is a race condition.
    }
    return instance;
  }

}
