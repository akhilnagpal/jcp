package interviewcake.KthToLastNode;

// Returns the node with value "Devil's Food" (the 2nd to last node)
// kth_to_last_node(2, a)

// TWO APPROACHES AS SHOWN BELOW

// What are our time and space costs?

// O(n) time and O(1) space, where n is the length of the list.

// More precisely, it takes n steps to get the length of the list, 
// and another n-k steps to reach the target node. 
// In the worst case k=1, so we have to walk all the way from head to tail again to reach the target node. 
// This is a total of 2n steps, which is O(n).

public class KthToLastNodeClient {
	
	static LinkedListNode kth_to_last_node(int kthNode, LinkedListNode head) {
		LinkedListNode currentNode=head;
		int lengthOfLinkedList=1;
		while(currentNode.next!=null) {
			lengthOfLinkedList++;
			currentNode=currentNode.next;
		}
		System.out.println("Length of Linked List:" + lengthOfLinkedList);
		currentNode=head;
		for(int count=0;count<(lengthOfLinkedList-kthNode);count++) {
			currentNode=currentNode.next;
		}
		return currentNode;
	}
	
	// there is another approach called stick approach. look at interview cake, in back up directory to check.
	// this also takes O(n) time and O(1) space. however if the processor algorithm is using LRU (Least Recently used),
	// the we can possibly it is faster as processor has to load less nodes in stick approach.
	// Also happens in single pass.
	//  Number of steps taken are same as first approach
	static LinkedListNode kth_to_last_node_UsingStick(int kthNode, LinkedListNode head) {
		LinkedListNode leftNode=head;
		LinkedListNode rightNode=head;
		
		for(int count=1;count<kthNode;count++) {			
			rightNode=rightNode.next;
		}
		// stick of kthNode size 
		// Now the left node of stick is start and far end of stick is right node, with distance of kthNode		
		while(rightNode.next!=null) {
			rightNode=rightNode.next;
			leftNode=leftNode.next;
		}
		return leftNode;
	}

	public static void main(String[] args) {
		LinkedListNode a = new LinkedListNode("Angel Food");
		LinkedListNode b = new LinkedListNode("Bundt");
		LinkedListNode c = new LinkedListNode("Cheese");
		LinkedListNode d = new LinkedListNode("Devil's Food");
		LinkedListNode e = new LinkedListNode("Eccles");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		String data = kth_to_last_node(2,a).data;
		System.out.println(data);
		// Using Stick way
		data = kth_to_last_node_UsingStick(2,a).data;
		System.out.println(data);
		
	}

}

class LinkedListNode{
	String data;
	LinkedListNode next;
	LinkedListNode(String d){
        data=d;
        next=null;
    }
	
}
