package java8inaction.chapter8.observer;

import java.io.IOException;

public class FeederMain {

  public static void main(String args[]) throws IOException {
    Subject twitter = new FeedSubject();
    twitter.registerObserver(new NYObserver());
    twitter.registerObserver(new LNObserver());
    twitter.notifyObserver("the queen is fabulous");
  }

}
