package algos.reverselinkedlist;

public class ReverseLinkedListExample {
	
	public static void main(String args[]) {
		ListNode listNode = new ListNode(1);
		ListNode nextNode  = listNode.setNextNode(new ListNode(2));
		nextNode = nextNode.setNextNode(new ListNode(3));
		nextNode = nextNode.setNextNode(new ListNode(4));	
		
		ListNode.printLinkedList(listNode);
		
		ListNode previous =reverse(listNode);	
		
		ListNode.printLinkedList(previous);
	}
	
	static ListNode reverse (ListNode listNode) {
		
		ListNode current=listNode;
		ListNode next=null;
		ListNode previous=null;
		
		 while(current!=null) {	
			 next=current.getNext();
			 current.setNextNode(previous);
			 previous=current;
			 current=next;
		 }
		 
		 return previous;
	}

}

