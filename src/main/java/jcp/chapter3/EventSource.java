package jcp.chapter3;

import java.util.EventListener;

public class EventSource {
  EventListener listener;

  public void registerEventListener(EventListener listener) {
    this.listener = listener;
  }

}
