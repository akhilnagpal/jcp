package interviewcake.binarysearchtreevalid;

import java.util.ArrayDeque;
import java.util.Deque;

public class DepthTraversalBinaryNodeChecker implements BinaryNodeChecker {

  class NodeBounds {
    BinaryTreeNode node;
    int lowBound;
    int highBound;

    public NodeBounds(BinaryTreeNode node, int lowBound, int highBound) {
      super();
      this.node = node;
      this.lowBound = lowBound;
      this.highBound = highBound;
    }


  }

  Deque<NodeBounds> nodeandBoundStack = new ArrayDeque<>();

  // This uses depth traversal o(n) in time but O(log n) in space
  // better than breadth which will have O(n) in case of space too
  // Better tan recursion as there will no stack over flow as in RecursionBinaryNodeChecker.
  @Override
  public boolean checkValidBinaryTree(BinaryTreeNode btd) {
    if (btd == null) {
      return true;
    }
    nodeandBoundStack.push(new NodeBounds(btd, Integer.MIN_VALUE, Integer.MAX_VALUE));
    while (!nodeandBoundStack.isEmpty()) {
      NodeBounds nodeBound = nodeandBoundStack.pop();
      BinaryTreeNode node = nodeBound.node;
      int lower = nodeBound.lowBound;
      int higher = nodeBound.highBound;
      if (node.value < lower || node.value > node.value) {
        return false;
      }

      if (node.left != null) {
        nodeandBoundStack.push(new NodeBounds(node.left, lower, node.value));
      }

      if (node.right != null) {
        nodeandBoundStack.push(new NodeBounds(node.right, node.value, higher));
      }

    }
    // reached leaf node.
    return true;
  }


}
