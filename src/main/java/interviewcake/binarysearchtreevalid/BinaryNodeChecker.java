package interviewcake.binarysearchtreevalid;

@FunctionalInterface
public interface BinaryNodeChecker {
  // http://lcm.csa.iisc.ernet.in/dsa/node91.html
  default void insertNode(BinaryTreeNode parentNode, BinaryTreeNode childNode, int level) {
    level++;
    if (parentNode.value < childNode.value) {
      if (parentNode.right == null) {
        parentNode.right = childNode;
        System.out.println("inserted " + childNode.value + " at level " + level);
      } else {
        insertNode(parentNode.right, childNode, level);
      }
    } else {
      if (parentNode.left == null) {
        parentNode.left = childNode;
        System.out.println("inserted " + childNode.value + " at level " + level);
      } else {
        insertNode(parentNode.left, childNode, level);
      }
    }

  }

  public abstract boolean checkValidBinaryTree(BinaryTreeNode btd);
}
