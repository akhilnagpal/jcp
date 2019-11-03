package jcp.chapter3;

import java.awt.Event;
import java.util.EventListener;


public class ThisEscape {

  public ThisEscape(EventSource eventSource) {
    eventSource.registerEventListener(new EventListener() {
      public void OnEvent(Event e) {
        doSomeThing(e);
      }
    });


  }

  private void doSomeThing(Event e) {
    // TODO Auto-generated method stub

  }
}
