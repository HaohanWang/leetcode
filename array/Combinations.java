package array;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
  public static void main(String args[]) {
    int n = 10;
    int k = 7;
    ArrayList<ArrayList<Integer>> r = new Combinations().combine(n, k);
    for (ArrayList<Integer> m : r) {
      for (int i : m) {
        System.out.print(i + "  ");
      }
      System.out.println();
    }
  }
/**
 * We do not need the flag to judge, for each number bigger than index, add it, 
 * recursive
 * then, delete it. 
 * @param n
 * @param k
 * @return
 */
  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    // Start typing your Java solution below
    // DO NOT write main() function
    boolean[] flag = new boolean[n];
    return combine(n, flag, k);
  }

  public ArrayList<ArrayList<Integer>> combine(int n, boolean[] flag, int k) {
    ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    if (k == 1) {
      for (int i = 0; i <= n - 1; i++) {
        if (flag[i] == false) {
          ArrayList<Integer> a = new ArrayList<Integer>();
          a.add(i + 1);
          r.add(a);
        }
      }
      return r;
    } else {
      for (int i = 0; i <= n - 1; i++) {
        if (flag[i] == false) {
          flag[i] = true;
          ArrayList<ArrayList<Integer>> a = combine(n, flag, k - 1);
          flag[i] = false;
          for (ArrayList<Integer> b : a) {
            b.add(i + 1);
            Collections.sort(b);
            if (!r.contains(b)) {
              r.add(b);
            }
          }
        }
      }
      return r;
    }
  }
}
