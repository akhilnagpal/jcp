package java8inaction.chapter8.observer;

public class LNObserver implements Observer {

  @Override
  public void notify(String tweet) {
    if (null != tweet && tweet.contains("queen")) {
      System.out.println("London News:" + tweet);
    }

  }

}
