package jcp.chapter3;

public class NoVisibility {

  private static boolean ready;
  private static int number;

  private static Thread readerThread = new Thread() {
    public void run() {
      // below operations might get re-ordered if no synchronization
      while (!ready) {
        Thread.yield();
      }
      System.out.println(Thread.currentThread().getName() + "---" + number);
    }

  };

  public static void main(String args[]) {
    readerThread.start();
    // below operations might get re-ordered if no synchronization
    number = 42;
    ready = true;
  }
}
