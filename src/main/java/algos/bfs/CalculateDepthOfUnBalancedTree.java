package algos.bfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// sample input
// 5 4 3 6 7 8 9
// Asked in T Rowe Price

public class CalculateDepthOfUnBalancedTree {
	
	static int leftdepth=0;
	static int rightdepth=0;
	
	public static void main (String[] args) throws java.lang.Exception
	  {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    String[] arrayString = input.split(" ");
	    
	    IntTreeNode root = new IntTreeNode(Integer.parseInt(arrayString[0]));
	    
	    for(int i=1;i<arrayString.length;i++) {
	    	add(root,Integer.parseInt(arrayString[i]));
	    }    
	    
	    System.out.println(maxDepth(root)-1);
	    
	  }
	
	private static IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
        	
            root.left = add(root.left, value);
        } else {

            root.right = add(root.right, value);
        }

        return root;
    }
	
	static int  maxDepth(IntTreeNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left); 
            int rDepth = maxDepth(node.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    } 	

}


class IntTreeNode{
	int data;
	IntTreeNode right;
	IntTreeNode left;
	IntTreeNode(int d){
        data=d;       
    }
	@Override
	public String toString() {
		return "IntTreeNode [data=" + data + "]";
	}
}