package linkedList;

public class RemoveNthNodeFromListEnd {
  /**
   * 
   * 
   * @param head
   * @param n
   * @return
   */
  public MyListNode removeNthFromEnd(MyListNode head, int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode H = new MyListNode(0); // this is important for linked list operations, it can save
                                      // so much troubles and it is easy to use.
    H.next = head;
    MyListNode p = head;
    MyListNode q = H;
    for (; p != null; p = p.next) {
      n--;
      if (n < 0) {
        q = q.next;
      }
    }
    q.next = q.next.next;
    if (q == H) // this is important because if we want to remove head, we cannot return head any
                // more.
      return q.next;
    return head;
  }
}
