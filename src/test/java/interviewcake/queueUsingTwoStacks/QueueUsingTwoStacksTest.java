package interviewcake.queueUsingTwoStacks;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueUsingTwoStacksTest {
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testEmptyQueue() throws EmptyQueueException {
    Queue<Object> queue = new QueueUsingTwoStacks();
    exceptionRule.expect(EmptyQueueException.class);
    exceptionRule.expectMessage("Queue is empty");
    queue.fetch();
  }

  @Test
  public void testMultipleInputs() throws EmptyQueueException {
    QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
    queue.add("Object 1");
    queue.add("Object 2");
    queue.add("Object 3");
    assertEquals("Object 1", queue.fetch());
    queue.add("Object 4");
    assertEquals("Object 2", queue.fetch());
    assertEquals(1, queue.getOutStackSize());

  }

  @Test
  public void testMultipleThreads() throws EmptyQueueException, InterruptedException {
    QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

    Thread enqueur = new Thread(new Enqueuer(queue), "Enqueuer Thread");
    Thread dequeur = new Thread(new Dequeur(queue), "Dequeuer Thread");
    enqueur.start();
    dequeur.start();
    Thread.sleep(1000);
    assertEquals(queue.getOutStackSize(), 0);
  }

  @Test
  public void testOneElementInQueue() throws EmptyQueueException {
    Queue<Object> queue = new QueueUsingTwoStacks();
    queue.add("Object 1");
    assertEquals("Object 1", queue.fetch());
  }
}
