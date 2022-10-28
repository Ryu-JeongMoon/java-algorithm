package algorithm.leetcode.easy;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class _104 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(maxDepth(root));

    TreeNode secondRoot = new TreeNode(1);
    secondRoot.right = new TreeNode(2);
    System.out.println(maxDepth(secondRoot));
  }

  public static int maxDepth(TreeNode root) {
    return root == null
      ? 0
      : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}

/*
time complexity
unbalanced binary tree -> O(n)

critical point
root != null
  && left == null
  && right == null -> 1을 반환
 */