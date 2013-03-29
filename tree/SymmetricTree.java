package tree;

import java.util.LinkedList;

public class SymmetricTree {

  public boolean isSymmetricRecursively(MyTreeNode root1, MyTreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null && root2 != null) {
      return false;
    } else if (root1 != null && root2 == null) {
      return false;
    } else {
      return (root1.val == root2.val) && isSymmetricRecursively(root1.left, root2.right)
              && isSymmetricRecursively(root1.right, root2.left);
    }
  }

  public boolean isSymmetricIteratively(MyTreeNode root) {
    LinkedList<MyTreeNode> l = new LinkedList<MyTreeNode>();
    LinkedList<MyTreeNode> r = new LinkedList<MyTreeNode>();
    l.add(root.left);
    r.add(root.right);
    MyTreeNode tl = null;
    MyTreeNode tr = null;
    while (!(l.isEmpty() || r.isEmpty())) {
      tl = l.get(0);
      tr = r.get(0);
      l.remove(0);
      r.remove(0);
      if (tl == null && tr == null)
        continue;
      else if (tl == null || tr == null)
        return false;
      else if (tl.val != tr.val)
        return false;
      else {
        l.add(tl.left);
        l.add(tl.right);
        r.add(tr.right);
        r.add(tr.left);
      }
    }
    if (l.isEmpty() && r.isEmpty())
      return true;
    return false;
  }
}
