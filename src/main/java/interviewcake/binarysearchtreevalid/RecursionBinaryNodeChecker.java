package interviewcake.binarysearchtreevalid;

public class RecursionBinaryNodeChecker implements BinaryNodeChecker {

  @Override
  public boolean checkValidBinaryTree(BinaryTreeNode btd) {
    if (!goOneNodeDeep(btd)) {
      return false;
    }
    return true;
  }

  private static boolean goOneNodeDeep(BinaryTreeNode btd) {
    if (btd.left != null) {
      // LeftNode logic
      if (btd.value < btd.left.value) {
        return false;
      } // traverse to left node deeper

      if (!goOneNodeDeep(btd.left)) {
        return false;
      }
    }
    if (btd.right != null) {
      if (btd.value > btd.right.value) {
        return false;
      }
      if (!goOneNodeDeep(btd.right)) {
        return false;
      }
    }
    return true;
  }

}
