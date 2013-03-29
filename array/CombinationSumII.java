package array;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
  public static void main(String args[]) {
    int[] candidates = { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25,
        32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24,
        12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12 };
    int target = 27;
    ArrayList<ArrayList<Integer>> result = new CombinationSumII().combinationSum22(candidates,
            target);
    for (ArrayList<Integer> ar : result) {
      System.out.println(ar);
    }
    System.out.println("end");
  }

  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num.length == 0)
      return result;
    Arrays.sort(num);
    return combinationSum2(num.length - 1, num, target);
  }

  ArrayList<ArrayList<Integer>> combinationSum2(int s, int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> m = new ArrayList<Integer>();
    System.out.println(s + " " + " " + target);
    if (s == 0) {
      if (num[s] == target) {
        m.add(num[s]);
        result.add(m);
        return result;
      } else {
        return result;
      }
    }
    result.addAll(combinationSum2(s - 1, num, target));
    ArrayList<ArrayList<Integer>> r = combinationSum2(s - 1, num, target - num[s]);
    if (target - num[s] == 0) {
      m.add(num[s]);
      if (!result.contains(m)) {
        result.add(m);
      }
    }
    for (ArrayList<Integer> n : r) {
      n.add(num[s]);
      if (!result.contains(n)) {
        result.add(n);
      }
    }
    return result;
  }
/**
 * A very good solution, always pass result into it. 
 * @param num
 * @param target
 * @return
 */
  public ArrayList<ArrayList<Integer>> combinationSum22(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    Arrays.sort(num);

    int[] backtrack = new int[num.length + 1];
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    backtrack[0] = -1;
    solve(num, 0, target, backtrack, result, 0);
    return result;
  }

  public void solve(int[] num, int sum, int target, int[] backtrack,
          ArrayList<ArrayList<Integer>> result, int n) {
    // backtrack records the indexes in num array
    // what is my next number's index? start trying from backtrack[n] + 1 to num's end
    if (target == sum) {
      // add everything in backtrack to result
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++) {
        ret.add(num[backtrack[i]]);
      }
      result.add(ret);
    }

    if (target < sum) {
      return;
    }
    for (int i = backtrack[n] + 1; i < num.length; i++) {
      backtrack[n + 1] = i;
      solve(num, sum + num[i], target, backtrack, result, n + 1);

      while (i + 1 < num.length && num[i + 1] == num[i]) {
        i++;
      }
    }
  }
}
