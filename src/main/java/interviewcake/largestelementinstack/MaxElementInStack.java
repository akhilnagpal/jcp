package interviewcake.largestelementinstack;

import java.util.Stack;

// You want to be able to access the largest element in a stack
public class MaxElementInStack {
  Stack<Integer> inputStack = new Stack<>();
  // What if when we find a new current max (new_max),
  // instead of overwriting the old one (old_max) we held onto it,
  // so that once new_max was popped off our stack we would know that our max was back to old_max?
  // What data structure should we store our set of maxes in?
  // We want something where the last item we put in is the first item we get out
  // ("last in, first out").
  // We can store our maxes in another stack!
  Stack<Integer> maxStack = new Stack<>();

  // Complexity = 0(1) for push
  // O(m) additional space, where m is the number of operations performed on the stack.
  public void push(int item) {
    inputStack.push(item);
    // I have added >= so that we can keep track of two max elements. This is important,
    // as we can pop the max element from maxStack and second max element will still exist
    // in the input stack. so we need to keep two max elements in max stack too.
    if (maxStack.isEmpty() || item >= maxStack.peek()) {
      maxStack.push(item);
    }
  }

  // Complexity = 0(1) for pop
  public int pop() throws Exception {
    if (inputStack.isEmpty()) {
      throw new Exception("Empty Stack");
    }
    int returnNumber = inputStack.pop();
    if (returnNumber == maxStack.peek()) {
      maxStack.pop();
    }
    return returnNumber;
  }

  // 0(1) for max
  // Notice how in the solution we're spending time on push() and pop()
  // so we can save time on get_max().
  // That's because we chose to optimize for the time cost of calls to get_max().
  // But we could've chosen to optimize for something else.
  // For example, if we expected we'd be running push() and pop() frequently and running get_max()
  // rarely,
  // we could have optimized for faster push() and pop() methods.
  // Sometimes the first step in algorithm design is deciding what we're optimizing for.
  // Start by considering the expected characteristics of the input.
  // For rare getMax call, I can do following
  // a. input
  public int getMax() {
    return maxStack.isEmpty() ? 0 : maxStack.peek();
  }
}
