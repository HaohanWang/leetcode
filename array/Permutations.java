package array;

import java.util.ArrayList;

public class Permutations {
  public static void main(String args[]) {
    int[] num = { 1, 2, 3 };
    ArrayList<ArrayList<Integer>> r = new Permutations().permutations(num);
    for (ArrayList<Integer> m : r) {
      System.out.println(m);
    }
    System.out.println("end");
  }

  public ArrayList<ArrayList<Integer>> permutations(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num.length == 0) {
      return result;
    }
    result = permutations(0, num);
    return result;
  }

  public ArrayList<ArrayList<Integer>> permutations(int n, int[] num) {
    ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> m = new ArrayList<Integer>();
    if (n == num.length - 1) {
      m.add(num[n]);
      r.add(m);
      return r;
    }
    ArrayList<ArrayList<Integer>> s = permutations(n + 1, num);
    for (int i = 0; i <= s.size() - 1; i++) {
      for (int j = 0; j <= s.get(i).size(); j++) {
        ArrayList<Integer> p = new ArrayList<Integer>();
        p.addAll(s.get(i));
        p.add(j, num[n]);
        r.add(p);
      }
    }
    return r;
  }
}
