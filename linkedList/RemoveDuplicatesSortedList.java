package linkedList;

public class RemoveDuplicatesSortedList {
  public MyListNode deleteDuplicates(MyListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null || head.next == null)
      return head;
    MyListNode Head = new MyListNode(0);
    Head.next = head;
    MyListNode q = Head;
    for (MyListNode p = head; p != null; p = p.next) {
      if (p.val == q.val && q != Head) {
        q.next = p.next;
      } else {
        q = q.next;
      }
    }
    return Head.next;
  }
}
