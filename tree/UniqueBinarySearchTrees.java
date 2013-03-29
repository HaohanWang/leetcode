package tree;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {
  public ArrayList<MyTreeNode> generateTrees(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<MyTreeNode> tree = new ArrayList<MyTreeNode>();
    if (n == 0) {
      tree.add(null);
      return tree;
    } else {
      return generateTrees(1, n);
    }
  }

  public ArrayList<MyTreeNode> generateTrees(int s, int e) {
    ArrayList<MyTreeNode> tree = new ArrayList<MyTreeNode>();
    if (s > e) {
      tree.add(null);
      return tree;
    }
    if (s == e) {
      MyTreeNode root = new MyTreeNode(s);
      tree.add(root);
      return tree;
    } else {
      for (int i = s; i <= e; i++) {
        ArrayList<MyTreeNode> left = generateTrees(s, i - 1);
        ArrayList<MyTreeNode> right = generateTrees(i + 1, e);
        for (MyTreeNode l : left) {
          for (MyTreeNode r : right) {
            MyTreeNode root = new MyTreeNode(i);
            root.left = l;
            root.right = r;
            tree.add(root);
          }
        }
      }
    }
    return tree;
  }
}
