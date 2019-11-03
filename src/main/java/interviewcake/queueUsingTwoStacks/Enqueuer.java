package interviewcake.queueUsingTwoStacks;



public class Enqueuer implements Runnable {

  Queue<Object> queue;
  boolean stop = false;
  private int counter = 0;

  public Enqueuer(Queue<Object> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (counter < 10) {
      String s = "Object " + counter++;
      System.out.println("Enqueuing " + s);
      queue.add(s);
      try {
        Thread.sleep(2);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    stop = true;
  }
}
