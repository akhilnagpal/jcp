package java8inaction.chapter8.observer;

import java.io.IOException;

public class FeederMainUsingLamda {

  public static void main(String args[]) throws IOException {
    Subject twitter = new FeedSubject();
    // Creating NYObserver Lamdas
    Observer nyObserver = (String tweet) -> {
      if (null != tweet && tweet.contains("money")) {
        System.out.println(tweet);
      }
    };
    Observer lnObserver = (String tweet) -> {
      if (null != tweet && tweet.contains("queen")) {
        System.out.println(tweet);
      }
    };

    twitter.registerObserver(nyObserver);
    twitter.registerObserver(lnObserver);

    twitter.notifyObserver("the queen is fabulous");
  }
}
