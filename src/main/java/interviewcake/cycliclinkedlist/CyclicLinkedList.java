package interviewcake.cycliclinkedlist;

import java.util.HashSet;
import java.util.Set;

public class CyclicLinkedList {

  // Solution using o(1) space - as we no longer store all the nodes in hashset which was
  // O(n)solution
  // Also we started with just two variables, slowRunner and fastRunner
  // and never created more variable. So we are O(1) in space
  // The time still is O(n) as we have two go through all nodes
  // The O(n) works on the basis of slowRunner, not on fastRunner which loops twice as slowRunner
  // See notes, that fastRunner will never skip the slowRunner. If it would have been then
  // in time this would never been the O(n) solution

  public boolean containsCycleUsingTwoRunner(Node node) {

    Node slowRunner = node;
    Node fastRunner = slowRunner;
    while (fastRunner != null && fastRunner.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
      if (fastRunner == slowRunner) {
        return true;
      }
    }
    return false;
  }

  // Below approach uses O(n) in time, because you are going through all nodes traversal
  // also it also uses O(n) in space, as HashSet can possibly holding all the nodes
  // as we traversed
  // I initially used ArrayList to store all traverse nodes, but then HashSet looks more efficient
  // As it is more faster to search using Hashing rather than traversing each element in the list.

  public boolean containsCycleUsingHashSet(Node node) {

    Node head = node;

    Node forwardNode = node.next;
    Set<Node> nodesTraversed = new HashSet<>();
    nodesTraversed.add(head);

    while (forwardNode != null) {
      if (nodesTraversed.contains(forwardNode)) {
        return true;
      }
      nodesTraversed.add(forwardNode);
      forwardNode = forwardNode.next;
    }
    return false;
  }

  public static void main(String args[]) {
    Node node1 = new Node();
    node1.value = 2;

    Node node2 = new Node();
    node2.value = 4;
    node1.next = node2;

    Node node3 = new Node();
    node3.value = 6;
    node2.next = node3;

    node3.next = node1;


    // Using O(n) in time and O(n) in space approach
    CyclicLinkedList cyclicLinkedList = new CyclicLinkedList();
    // should be true;
    System.out.println(cyclicLinkedList.containsCycleUsingHashSet(node1));
    node3.next = null;
    // should be false;
    System.out.println(cyclicLinkedList.containsCycleUsingHashSet(node1));
    node3.next = node2;
    // should be true;
    System.out.println(cyclicLinkedList.containsCycleUsingHashSet(node1));

    // Using O(n) in time and O(1) in space approach
    // used less memory that containsCycleUsingHashSet
    node3.next = node1;
    // should be true;
    System.out.println(cyclicLinkedList.containsCycleUsingTwoRunner(node1));
    node3.next = null;
    // should be false;
    System.out.println(cyclicLinkedList.containsCycleUsingTwoRunner(node1));
    node3.next = node2;
    // should be true;
    System.out.println(cyclicLinkedList.containsCycleUsingTwoRunner(node1));
  }
}


class Node {
  public Node next;
  public int value;
}
