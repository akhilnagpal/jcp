package interviewcake.largestelementinstack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxElementInStackTest {

  MaxElementInStack maxElementInStack = new MaxElementInStack();

  @Test
  public void testMaxElement() throws Exception {
    maxElementInStack.push(4);
    assertEquals(4, maxElementInStack.getMax());
    maxElementInStack.push(3);
    assertEquals(4, maxElementInStack.getMax());
    maxElementInStack.pop();
    assertEquals(4, maxElementInStack.getMax());
    maxElementInStack.push(5);
    assertEquals(5, maxElementInStack.getMax());
    maxElementInStack.push(1);
    maxElementInStack.push(6);
    maxElementInStack.push(6);
    assertEquals(6, maxElementInStack.getMax());
    maxElementInStack.pop();// first 6 is out
    assertEquals(6, maxElementInStack.getMax());
    maxElementInStack.pop();// second 6 is out
    assertEquals(5, maxElementInStack.getMax());
    maxElementInStack.pop();// 1 is out
    assertEquals(5, maxElementInStack.getMax());
    maxElementInStack.pop();// 5 is out
    assertEquals(4, maxElementInStack.getMax());
    maxElementInStack.pop();// 4 is out
    // below getMax will populate 0 = default value;
    assertEquals(0, maxElementInStack.getMax());
  }
}
