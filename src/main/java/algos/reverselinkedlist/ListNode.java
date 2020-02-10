package algos.reverselinkedlist;

public class ListNode {
	private ListNode next;
	
	private int value;
	
	public ListNode(int value) {
		this.setValue(value);
	}
	
	public ListNode setNextNode(ListNode next) {
		this.next=next;
		return this.next;
	}
	
	public ListNode getNext() {
		return this.next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static void  printLinkedList(ListNode listNode) {
		System.out.println(listNode.value);
		while(listNode.getNext() !=null) {
			System.out.println(listNode.getNext().getValue());
			listNode=listNode.getNext();
		}
		
	}
}

