package tree;

import java.util.ArrayList;

public class PathSum2 {
  public ArrayList<ArrayList<Integer>> pathSum(MyTreeNode root, int sum) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    } else {
      ArrayList<Integer> current = new ArrayList<Integer>();
      path(root, sum, result, current);
      return result;
    }
  }

  public void path(MyTreeNode root, int sum, ArrayList<ArrayList<Integer>> result,
          ArrayList<Integer> current) {
    if (root.left == null && root.right == null) {
      current.add(root.val);
      for (int i : current) {
        sum -= i;
      }
      if (sum == 0) {
        result.add(current);
      }
    } else {
      current.add(root.val);
      if (root.left != null) {
        ArrayList<Integer> currentLeft = new ArrayList<Integer>();
        for (int i : current) {
          currentLeft.add(i);
        }
        path(root.left, sum, result, currentLeft);
      }
      if (root.right != null) {
        ArrayList<Integer> currentRight = new ArrayList<Integer>();
        for (int i : current) {
          currentRight.add(i);
        }
        path(root.right, sum, result, currentRight);
      }
    }
  }

  public ArrayList<ArrayList<Integer>> pathSumII(MyTreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    }
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(root.val);
        result.add(l);
        return result;
      } else {
        return result;
      }
    } else {
      ArrayList<ArrayList<Integer>> l = pathSum(root.left, sum - root.val);
      ArrayList<ArrayList<Integer>> r = pathSum(root.right, sum - root.val);
      for (ArrayList<Integer> al : l) {
        al.add(0, root.val);
        result.add(al);
      }
      for (ArrayList<Integer> al : r) {
        al.add(0, root.val);
        result.add(al);
      }
      return result;
    }
  }
}
