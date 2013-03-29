package linkedList;

public class RemoveDuplicatesSortedListII {
  public MyListNode deleteDuplicates(MyListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null || head.next == null)
      return head;
    MyListNode Head = new MyListNode(0);
    Head.next = head;
    MyListNode q = Head;
    for (MyListNode p = head; p != null; p = p.next) {
      if (p.next != null && p.val != p.next.val) {
        q.next = p;
        q = q.next;
      }
      if (p.next == null) {
        q.next = p;
        q = q.next;
      } else {
        while (p.next != null && p.val == p.next.val) {
          p = p.next;
        }
      }
    }
    q.next = null;
    return Head.next;
  }
}
