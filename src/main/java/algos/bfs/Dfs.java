package algos.bfs;

public class Dfs {

	public static void main(String[] args) {
		Node node = new Node(new Node(
				new Node("C"),new Node("D"),"B"),
				new Node(new Node(new Node("H"),null,"F"),new Node("G"),"E"),
				"A");
		traversal(node);
	}
	
	public static void traversal(Node node) {
		System.out.println(node);
		if(node.left!=null) {
			traversal(node.left);
		}
		if(node.right!=null) {
			traversal(node.right);
		}

	}

}
