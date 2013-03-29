package linkedList;

import java.util.Scanner;

public class PartitionList {
  /**
   * Pay attention how the next moves
   * 
   * For head node, we can generate a new one. 
   * @param args
   */
  
  
  
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
    head = new PartitionList().partition(head, 3);
    while (head != null) {
      System.out.print(head.val+ " ");
      head = head.next;
    }
  }

  public MyListNode partition(MyListNode head, int x) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null)
      return null;
    MyListNode begin = null;
    MyListNode end = begin;
    MyListNode q = null;
    for (MyListNode p = head; p != null; p = p.next) {
      if (p.val < x) {
        if (q == null) {
          begin = new MyListNode(p.val);
          head = head.next;
          end = begin;
        } else {
          if (begin == null) {
            begin = p;
            end = p;
            q.next = q.next.next;
            p.next = null;
            p = q;
          } else {
            q.next = q.next.next;
            if (head==p){
              head=head.next;
            }
            end.next = p;
            p.next = null;
            end = end.next;
            p = q;
          }
        }
      }
      q = p;
    }
    if (end != null) {
      end.next = head;
      return begin;
    } else
      return head;
  }
}
