package java8inaction.chapter8.observer;

public interface Subject {
  public void registerObserver(Observer observer);

  public void notifyObserver(String tweet);

}
