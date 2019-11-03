package interviewcake.queueUsingTwoStacks;


public interface Queue<T> {

  void add(T object);

  T fetch() throws EmptyQueueException;

}
