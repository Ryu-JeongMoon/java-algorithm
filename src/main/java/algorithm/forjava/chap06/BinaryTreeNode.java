package algorithm.forjava.chap06;

import java.util.Stack;

public class BinaryTreeNode {

  private int data;

  private BinaryTreeNode left;

  private BinaryTreeNode right;

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryTreeNode getLeft() {
    return left;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode getRight() {
    return right;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }

  void searchPreorderRecursively(BinaryTreeNode root) {
    if (root != null) {
      System.out.println(root.getData());
      searchPreorderRecursively(root.getLeft());
      searchPreorderRecursively(root.getRight());
    }
  }

  void searchPreorderByStack(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    Stack<BinaryTreeNode> s = new Stack<>();
    while (true) {
      while (root != null) {
        System.out.println(root.getData());
        s.push(root);
        root = root.getLeft();
      }
      if (s.isEmpty()) {
        break;
      }

      root = s.pop();
      root = root.getRight();
    }
  }

  void searchInorderRecursively(BinaryTreeNode root) {
    if (root != null) {
      searchInorderRecursively(root.getLeft());
      System.out.println(root.getData());
      searchInorderRecursively(root.getRight());
    }
  }

  void searchInorderByStack(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    Stack<BinaryTreeNode> s = new Stack<>();
    while (true) {
      while (root != null) {
        s.push(root);
        root = root.getLeft();
      }

      if (s.isEmpty()) {
        break;
      }

      root = s.pop();
      System.out.println(root.getData());
      root = root.getRight();
    }
  }

  void searchPostorderRecursively(BinaryTreeNode root) {
    if (root != null) {
      searchPostorderRecursively(root.getLeft());
      searchPostorderRecursively(root.getRight());
      System.out.println(root.getData());
    }
  }
}
