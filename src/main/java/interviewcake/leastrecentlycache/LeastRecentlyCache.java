package interviewcake.leastrecentlycache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LeastRecentlyCache {
  private Deque<Integer> queue = new LinkedList<>();
  private HashSet<Integer> map = new HashSet<>();
  int maxSize;

  public LeastRecentlyCache(int size) {
    this.maxSize = size;
  }

  public void refer(int entry) {
    if (!map.contains(entry)) {
      // To check for max size
      if (map.size() == maxSize) {
        map.remove(entry);
        queue.removeLast();
      }
    } else {
      int i = 0;
      int index = 0;
      Iterator<Integer> iterator = queue.iterator();
      while (iterator.hasNext()) {
        int value = iterator.next();
        if (entry == value) {
          index = i;
          break;
        }
        i++;
      }
      map.remove(entry);
      // why index
      queue.remove(entry);
    }
    map.add(entry);
    queue.push(entry);
  }

  // display contents of cache
  public void display() {
    Iterator<Integer> itr = queue.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }

  }

  public static void main(String[] args) {
    LeastRecentlyCache ca = new LeastRecentlyCache(4);
    ca.refer(1);
    ca.refer(2);
    ca.refer(3);
    ca.refer(1);
    ca.refer(4);
    ca.refer(5);
    ca.display();
  }
}
