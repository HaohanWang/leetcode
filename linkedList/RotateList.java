package linkedList;

public class RotateList {
  public MyListNode rotateRight(MyListNode head, int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null || head.next == null)
      return head;
    MyListNode Head = new MyListNode(0);
    Head.next = head;
    MyListNode p = Head;
    MyListNode q = Head;
    int count = 0;
    for (p = Head.next; p != null; p = p.next) {
      count++;
    }
    n = n % count;
    count = 0;
    for (p = Head; p.next != null; p = p.next) {
      count++;
      if (count > n) {
        q = q.next;
      }
    }
    p.next = Head.next;
    Head.next = q.next;
    q.next = null;
    return Head.next;
  }
}
