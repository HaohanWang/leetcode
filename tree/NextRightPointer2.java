package tree;

public class NextRightPointer2 {
  /**
   * Think this recursively, for this level, I have already known the last level of of right pointer. 
   * @param root
   */
  public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root != null) {
      TreeLinkNode p = root;
      while (p != null) {
        if (p.right != null) {
          p.right.next = findNext(p.next);
          if (p.left != null) {
            p.left.next = p.right;
          }
        } else {
          if (p.left != null) {
            p.left.next = findNext(p.next);
          }
        }
        p = p.next;
      }
      p = root;
      while (p != null) {
        if (p.left != null) {
          connect(p.left);
          break;
        }
        if (p.right != null) {
          connect(p.right);
          break;
        }
        p = p.next;
      }
    }
  }

  public TreeLinkNode findNext(TreeLinkNode p) {
    while (p != null) {
      if (p.left != null) {
        return p.left;
      }
      if (p.right != null) {
        return p.right;
      }
      p = p.next;
    }
    return null;
  }
}
