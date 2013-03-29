package linkedList;

import java.util.Scanner;

public class ReverseLinkedList {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int num=in.nextInt();
    MyListNode h = new MyListNode(in.nextInt());
    MyListNode head = h;
    for (int i=1;i<=num-1;i++){
      MyListNode m = new MyListNode(in.nextInt());
      h.next=m;
      h=m;
    }
    head = new ReverseLinkedList().reverseBetween(head, 3, 7);
    while (head!=null){
      System.out.print(head.val+ " ");
      head=head.next;
    }
  }
  
  public MyListNode reverseBetween(MyListNode head, int m, int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyListNode s = null, h = null, p = null, q = null, t = null;
    if (m == n)
      return head;
    MyListNode head2 = new MyListNode(0);
    head2.next = head;
    s = head2;
    for (int i = m - 1; i >= 1; i--) {
      s = s.next;
    }
    h = s.next;
    t = h.next;
    q = h;
    for (n = n - m; n >= 1; n--) {
      p = t;
      t = p.next;
      h.next = t;
      p.next = q;
      q = p;
    }
    s.next = p;
    if (m == 1)
      return s.next;
    else
      return head;
  }
}
