package java8inaction.chapter8.chainofresponsibility;

public abstract class Processor<T> {
  protected Processor<T> sucessor;

  public void chain(T input) {
    input = handle(input);
    if (sucessor != null) {
      input = sucessor.handle(input);
    }
    System.out.println(input);
  }

  public abstract T handle(T input);

  public void setSucessor(Processor<T> sucessor) {
    this.sucessor = sucessor;
  }

}
