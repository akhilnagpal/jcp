package algos.middleElementOfLinkedList;

import algos.reverselinkedlist.ListNode;

public class MiddleEelement {
	
	public static void main(String args[]) {
	
	ListNode listNode = new ListNode(1);
	ListNode nextNode  = listNode.setNextNode(new ListNode(2));
	nextNode = nextNode.setNextNode(new ListNode(3));
	nextNode = nextNode.setNextNode(new ListNode(4));
	nextNode = nextNode.setNextNode(new ListNode(5));
	
	ListNode current = listNode;
	ListNode middle = listNode;
	int i=0;
	while(current!=null) {
		i++;
		current=current.getNext();
		if (i%2==0) {
			middle=middle.getNext();
		}		
	}
	
	System.out.println(middle.getValue());
	
	}

}
