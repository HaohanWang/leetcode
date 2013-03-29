package linkedList;

public class AddTwoNumbers {
  /**
   * This is other's solution. 
   * First, carry is called carry
   * this solution wasted some space, but original ones stay intact, so we can talk this to interviewer. 
   * this solution does not play any fancy stuff, which i can learn. 
   * @param l1
   * @param l2
   * @return
   */
  public MyListNode addTwoNumbers(MyListNode l1, MyListNode l2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode n1 = l1, n2 = l2;
    MyListNode head = new MyListNode(1);
    int carry = 0;
    MyListNode cur = head;
    while (n1 != null && n2 != null) {
      cur.next = new MyListNode((n1.val + n2.val + carry) % 10);
      carry = (n1.val + n2.val + carry) / 10;
      n1 = n1.next;
      n2 = n2.next;
      cur = cur.next;
    }
    MyListNode n = null;
    if (n1 == null) {
      n = n2;
    } else {
      n = n1;
    }
    while (n != null) {
      cur.next = new MyListNode((n.val + carry) % 10);
      carry = (n.val + carry) / 10;
      n = n.next;
      cur = cur.next;
    }
    if (carry == 1) {
      cur.next = new MyListNode(1);
      cur = cur.next;
    }
    cur.next = null;
    return head.next;
  }
}
