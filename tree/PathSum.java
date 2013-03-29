package tree;

public class PathSum {
  public boolean hasPathSum(MyTreeNode root, int sum) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root == null) {
      return false;
    } else {
      if (root.left == null && root.right == null) {
        if (root.val == sum)
          return true;
        else
          return false;
      } else {
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
      }
    }
  }
}
