package tree;



public class FlattenTreeToPreorder {
  public void flatten(MyTreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root != null) {
      MyTreeNode r = root.right;
      root.right = root.left;
      flatten(root.right);
      root.left = null;
      while (root.right != null) {
        root = root.right;
      }
      root.right = r;
      flatten(root.right);
    }
  }
}
