package jcp.chapter3;

import java.awt.Event;
import java.util.EventListener;


@SuppressWarnings("deprecation")
public class ThisEscape {

  public ThisEscape(EventSource eventSource) {
    eventSource.registerEventListener(new EventListener() {
      @SuppressWarnings("unused")
	public void OnEvent(Event e) {
        doSomeThing(e);
      }
    });


  }

  private void doSomeThing(Event e) {
    // TODO Auto-generated method stub

  }
}
