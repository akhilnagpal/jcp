package java8inaction.chapter8.observer;

public class NYObserver implements Observer {

  @Override
  public void notify(String tweet) {
    if (null != tweet && tweet.contains("money")) {
      System.out.println(tweet);
    }

  }

}
