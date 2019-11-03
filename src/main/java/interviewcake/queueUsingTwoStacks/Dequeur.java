package interviewcake.queueUsingTwoStacks;



public class Dequeur implements Runnable {

  Queue<Object> queue;
  boolean stop = false;
  private int counter = 0;

  public Dequeur(Queue<Object> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (counter < 10) {
      try {
        queue.fetch();
        counter++;
        Thread.sleep(1);
      } catch (EmptyQueueException e) {
        // System.err.println("Got EmptyQueueException");
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
