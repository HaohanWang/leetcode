package tree;

public class RecoveryBST {
  MyTreeNode pre = null;

  MyTreeNode[] curr = new MyTreeNode[4];

  int index = 0;

  public void recoverTree(MyTreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    index = 0;
    pre = null;
    if (root != null) {
      inOrder(root);
      int val = curr[index - 1].val;
      curr[index - 1].val = curr[0].val;
      curr[0].val = val;
    }
  }

  public void inOrder(MyTreeNode root) {
    if (root != null) {
      inOrder(root.left);
      if (pre == null) {
        pre = root;
      } else if (root.val < pre.val) {
        curr[index++] = pre;
        curr[index++] = root;
        pre = root;
      } else {
        pre = root;
      }
      inOrder(root.right);
    }
  }
}
