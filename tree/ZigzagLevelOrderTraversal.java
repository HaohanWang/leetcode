package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigzagLevelOrderTraversal {
  public static void main(String args[]) {
    MyTreeNode root = new MyTreeNode(1);
    root.left = new MyTreeNode(2);
    root.right = new MyTreeNode(3);
    ArrayList<ArrayList<Integer>> result = new ZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    for (ArrayList<Integer> m : result) {
      for (int a : m) {
        System.out.print(a);
      }
      System.out.println();
    }
  }
  /**
   * We can use slightly better implementation for this, which is using two stacks 
   * and a flag for add leftchild first or right one first
   * @param root
   * @return ArrayList<ArrayList<Integer>>
   * @author haohanwang
   */
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(MyTreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return result;
    LinkedList<MyTreeNode> queue = new LinkedList<MyTreeNode>();
    queue.add(root);
    int count = 1;
    int nextLevel = 0;
    boolean reverse = false;
    ArrayList<Integer> temp = new ArrayList<Integer>();  // pay attention to the lifespan of this variable. 
    while (!queue.isEmpty()) {
      MyTreeNode tmp = queue.get(0);
      if (tmp.left != null) {
        queue.add(tmp.left);
        nextLevel++;
      }
      if (tmp.right != null) {
        queue.add(tmp.right);
        nextLevel++;
      }
      temp.add(tmp.val);
      queue.remove(0);
      count--;
      if (count == 0) {
        if (reverse) {
          ArrayList<Integer> r = new ArrayList<Integer>();
          for (int i = temp.size() - 1; i >= 0; i--) {
            r.add(temp.get(i));
          }
          result.add(r);
          reverse = false;
        } else {
          ArrayList<Integer> r = new ArrayList<Integer>();
          for (int i = 0; i <= temp.size() - 1; i++) {
            r.add(temp.get(i));
          }
          result.add(r);
          reverse = true;
        }
        temp.clear();
        count = nextLevel;
        nextLevel = 0;
      }
    }
    return result;
  }
}
