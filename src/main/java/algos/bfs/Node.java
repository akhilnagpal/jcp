package algos.bfs;

public class Node {
	
	Node left;
	Node right;
	String data; 
	
	public Node(String data) {
		this.data=data;
	}
	
	public Node(Node left,Node right, String data) {
		this.left=left;
		this.right=right;
		this.data=data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	

}
