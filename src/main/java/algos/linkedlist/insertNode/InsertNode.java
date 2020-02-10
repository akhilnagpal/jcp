package algos.linkedlist.insertNode;



class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}

public class InsertNode {
	//Always make diagram of pointers before solving it.
	    public static  Node insert(Node head,int data) {
	        if(head==null) {
	            head= new Node(data);
	            return head;
	        }

	        Node current=head.next;
	        Node previous=head;
	        
	        while(current!=null) {    
	                previous=current;        
	                current=current.next;                
	        }
	        
	        current=new Node(data); 
	        previous.next=current;       
	        return head;      
	        
	    }
}
