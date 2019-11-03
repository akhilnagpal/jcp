package interviewcake.binarysearchtreevalid;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryNodeCheckerClient {
  static Deque<BinaryTreeNode> stackOfBinaryTreeNodes = new ArrayDeque<>();
  private static int level = 0;

  public static void main(String args[]) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
      // inserting the values 13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18 in that order,
      BinaryNodeChecker binaryNodeChecker = new RecursionBinaryNodeChecker();
      BinaryTreeNode node = new BinaryTreeNode(13);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(3), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(4), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(12), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(14), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(10), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(5), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(1), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(8), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(2), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(7), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(9), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(11), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(6), level);
      binaryNodeChecker.insertNode(node, new BinaryTreeNode(18), level);

      BinaryTreeNode inValidTree = new BinaryTreeNode(14);
      inValidTree.right = new BinaryTreeNode(3);
      System.out.println(binaryNodeChecker.checkValidBinaryTree(inValidTree));

      // checking using recursion way - it might cause stack overflow
      System.out.println(binaryNodeChecker.checkValidBinaryTree(node));
      System.out.println(binaryNodeChecker.checkValidBinaryTree(inValidTree));
      // done using depth traversal which uses Stack class, isntead of stack memory
      binaryNodeChecker = new RecursionBinaryNodeChecker();
      System.out.println(binaryNodeChecker.checkValidBinaryTree(node));
      System.out.println(binaryNodeChecker.checkValidBinaryTree(inValidTree));
      Thread.currentThread().sleep(1000);
    }



  }



}
