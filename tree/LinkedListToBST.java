package tree;

import linkedList.MyListNode;

public class LinkedListToBST {
  static MyListNode current = null;

  public MyTreeNode sortedListToBST(MyListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int count = 0;
    for (MyListNode p = head; p != null; p = p.next) {
      count++;
    }
    if (count == 0) {
      return null;
    }
    current = head;
    MyTreeNode root = sortedListToBST(0, count);
    return root;
  }

  public MyTreeNode sortedListToBST(int left, int right) {
    if (left > right) {
      return null;
    } else if (current == null) {
      return null;
    } else {
      int mid = (right - left) / 2 + left;
      MyTreeNode leftchild = sortedListToBST(left, mid - 1);
      MyTreeNode root = new MyTreeNode(current.val);
      root.left = leftchild;
      current = current.next;
      root.right = sortedListToBST(mid + 1, right);
      return root;
    }
  }
}
