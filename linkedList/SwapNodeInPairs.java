package linkedList;

public class SwapNodeInPairs {
  /**
   * Pay attention that p's position has changed!!
   * so we do not need to move p twice each time, only once is enough. 
   * @param head
   * @return
   */
  public MyListNode swapPairs(MyListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode h = new MyListNode(0);
    MyListNode q = h;
    MyListNode p = head;
    h.next = p;
    for (; p != null && p.next != null; p = p.next) {
      MyListNode t = p.next.next;
      q.next = p.next;
      p.next.next = p;
      p.next = t;
      q = p;
    }
    return h.next;
  }
}
