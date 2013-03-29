package linkedList;

public class MergeTwoSortedLists {
  public MyListNode mergeTwoLists(MyListNode l1, MyListNode l2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode Head1 = new MyListNode(0);
    MyListNode Head2 = new MyListNode(0);
    Head1.next = l1;
    Head2.next = l2;
    MyListNode q1 = Head1;
    MyListNode q2 = Head2;
    MyListNode Result = new MyListNode(0);
    MyListNode t = Result;
    MyListNode p1 = Head1.next;
    MyListNode p2 = Head2.next;
    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        t.next = p1;
        p1 = p1.next;
        q1 = q1.next;
        t = t.next;
      } else {
        t.next = p2;
        p2 = p2.next;
        q2 = q2.next;
        t = t.next;
      }
    }
    if (p1 != null) {
      t.next = p1;
    }
    if (p2 != null) {
      t.next = p2;
    }
    return Result.next;
  }
}
