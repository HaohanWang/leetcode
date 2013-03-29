package linkedList;

import java.util.Scanner;

public class ReverseNodesInKGroups {
  
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    MyListNode h = new MyListNode(in.nextInt());
    MyListNode head = h;
    for (int i = 1; i <= num - 1; i++) {
      MyListNode m = new MyListNode(in.nextInt());
      h.next = m;
      h = m;
    }
    head = new ReverseNodesInKGroups().reverseKGroup(head, 3);
    while (head != null) {
      System.out.print(head.val+ " ");
      head = head.next;
    }
  }
  
  public MyListNode reverseKGroup(MyListNode head, int k) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (k == 1)
      return head;
    MyListNode H = new MyListNode(0);
    H.next = head;
    MyListNode q = H;
    for (MyListNode p = head; p != null; p = p.next) {
      p = reverseK(q, k);
      if (p == null)
        break;
      q = p;
    }
    return H.next;
  }

  public MyListNode reverseK(MyListNode p, int k) {
    int n = k;
    MyListNode q = p;
    MyListNode s = q.next;
    for (; s != null; s = s.next) {
      n--;
      if (n == 0) {   //pay attention to the sequence of this, sometimes, we minus first then assert
        break;
      }
    }
    if (n > 0)
      return null;
    else {
      p = q.next;
      q.next = s;
      MyListNode f = p;
      q = f;
      p = p.next;
      f.next = s.next;
      for (int i = 2; i <= k&&p!=null; i++) {
        s = p.next;
        p.next = f;
        f = p;
        p = s;
      }
    }
    return q;
  }
}
