package interviewcake.queueUsingTwoStacks;

public class EmptyQueueException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  EmptyQueueException(String message) {
    super(message);

  }

  String getExceptionMessage() {
    return super.getMessage();
  }
}
