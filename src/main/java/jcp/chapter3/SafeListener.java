package jcp.chapter3;

import java.awt.Event;
import java.util.EventListener;


@SuppressWarnings("deprecation")
public class SafeListener {

  private EventListener listener;

  private SafeListener() {
    listener = new EventListener() {
      @SuppressWarnings("unused")
	public void OnEvent(Event e) {
        doSomeThing(e);
      }
    };
  }

  public static SafeListener getInstance(EventSource source) {
    //
    SafeListener safeListener = new SafeListener();
    // SafeListener is now fully constructed.
    // Now you can register the listener to the source
    // Any thread which is accessing the source now has fully constructed SafeListener.
    source.registerEventListener(safeListener.listener);
    return safeListener;
  }

  private void doSomeThing(Event e) {
    // TODO Auto-generated method stub

  }


}
