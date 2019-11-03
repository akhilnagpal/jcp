package java8inaction.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

public class FeedSubject implements Subject {

  private List<Observer> observers = new ArrayList<>();

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void notifyObserver(String tweet) {
    for (Observer observer : observers) {
      observer.notify(tweet);
    }
  }

}
