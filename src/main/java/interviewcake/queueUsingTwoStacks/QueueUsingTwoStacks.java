package interviewcake.queueUsingTwoStacks;

import java.util.Stack;

public class QueueUsingTwoStacks implements Queue<Object> {

  Stack<Object> inStack = new Stack<>();
  Stack<Object> outStack = new Stack<>();

  public int getOutStackSize() {
    return outStack.size();
  }

  @Override
  // Provides O(1) for enqueue
  public void add(Object object) {
    synchronized (inStack) {
      inStack.push(object);
    }

  }

  @Override
  // Generally O(1) for dequeue, except when the second stack is empty
  // them max would be O(n) or o(n/2), assuming input was stacked with n elements
  public Object fetch() throws EmptyQueueException {
    // || secondStack.peek() != null
    synchronized (outStack) {
      if (!outStack.isEmpty()) {
        // Takes O(1) time
        Object obj = outStack.pop();
        System.out.println("Popping out" + obj);
        return obj;
      }
    }

    // one off when second stack is empty
    synchronized (inStack) {
      synchronized (outStack) {
        boolean checkFirstStack = inStack.isEmpty();
        if (checkFirstStack) {
          throw new EmptyQueueException("Queue is empty");
        }
        // Start transferring the contents from non empty firstStack to secondStack
        while (!inStack.isEmpty()) {
          Object o = inStack.pop();
          outStack.push(o);
        }
        Object obj = outStack.pop();
        System.out.println("Popping out" + obj);
        return obj;
      }

    }

  }
}
