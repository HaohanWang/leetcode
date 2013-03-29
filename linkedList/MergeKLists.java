package linkedList;

import java.util.ArrayList;

public class MergeKLists {
  public MyListNode mergeKLists(ArrayList<MyListNode> lists) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode head = new MyListNode(Integer.MIN_VALUE);
    MyListNode[] p = new MyListNode[lists.size()];
    for (int i = 0; i <= p.length - 1; i++) {
      p[i] = lists.get(i);
    }
    MyListNode q = pickNext(lists, p);
    head.next = q;
    while (q != null) {
      q.next = pickNext(lists, p);
      q = q.next;
    }
    return head.next;
  }

  public MyListNode pickNext(ArrayList<MyListNode> lists, MyListNode[] p) {
    int min = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i <= p.length - 1; i++) {
      if (p[i] != null && min > p[i].val) {
        min = p[i].val;
        index = i;
      }
    }
    if (index == -1)
      return null;
    else {
      MyListNode q = p[index];
      p[index] = p[index].next;
      return q;
    }
  }
}
