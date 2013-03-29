package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
  public static void main(String args[]) {
    int[] candidates = { 2, 3, 6,7 };
    int target = 7;
    ArrayList<ArrayList<Integer>> result = new CombinationSum().combinationSum(candidates, target);
    for (ArrayList<Integer> ar : result) {
      System.out.println(ar);
    }
  }

  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (candidates.length == 0)
      return result;
    Arrays.sort(candidates);
    int[][] sum = new int[target + 1][candidates.length];
    for (int j = 0; j <= candidates.length - 1; j++) {
      if (candidates[j] <= target) {
        sum[candidates[j]][j] = -1;
      }
    }
    for (int i = 0; i <= target; i++) {
      for (int j = 0; j <= candidates.length - 1; j++) {
        if (i - candidates[j] >= 0) {
          for (int k = 0; k <= candidates.length - 1; k++) {
            if (sum[i - candidates[j]][k] != 0) {
              sum[i][j] = k + 1;
              break;
            }
          }
        }
      }
    }
    for (int j = candidates.length - 1; j >= 0; j--) {
      if (sum[target][j] != 0) {
        ArrayList<ArrayList<Integer>> r=addSum(j, target, sum, candidates);
        for (ArrayList<Integer> m : r) {
          if (!result.contains(m)){
            result.add(m);
          }
        }
      }
    }
    return result;
  }

  public ArrayList<ArrayList<Integer>> addSum(int j, int i, int[][] sum, int[] candidates) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    if (sum[i][j] == -1) {
      path.add(candidates[j]);
      result.add(path);
      return result;
    }
    for (int k = sum[0].length - 1; k >= sum[i][j] - 1; k--) {
      if (sum[i - candidates[j]][k] != 0) {
        ArrayList<ArrayList<Integer>> r = addSum(k, i - candidates[j], sum, candidates);
        for (ArrayList<Integer> m : r) {
          m.add(candidates[j]);
          Collections.sort(m);
          if (!result.contains(m)){
            result.add(m);
          }
        }
      }
    }
    return result;
  }
}
