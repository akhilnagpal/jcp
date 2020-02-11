package algos.bfs;

import java.util.LinkedList;
import java.util.Queue;

// Reference
//https://www.youtube.com/watch?v=Kfm00t4YKow

public class Bfs {

	public static void main(String[] args) {
		Node node = new Node(new Node(
				new Node("C"),new Node("D"),"B"),
				new Node(new Node(new Node("H"),null,"F"),new Node("G"),"E"),
				"A");
		traversal(node);
	}
	
	public static void traversal(Node node) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(queue.peek()!=null) {
			Node printNode = queue.poll();
			System.out.println(printNode);
			if(printNode.left!=null) {
				queue.add(printNode.left);				
			}
			if(printNode.right!=null) {
				queue.add(printNode.right);
			}
			
			
		}
	}

}
