package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
  public static void main(String args[]){
    int [] num = {3,9};
    ArrayList<ArrayList<Integer>> result = new Subsets().subsetsWithDup(num);
    for (ArrayList<Integer> ai : result){
      System.out.println(ai);
    }
  }
  /**
   * Better implementation: for any int, if the next one is the same as this one, do not consider it. 
   * @param num
   * @return
   */
  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    // Start typing your Java solution below
    // DO NOT write main() function
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    result.add(new ArrayList<Integer>());
    for (int i = 0; i <= num.length - 1; i++) {
      int max = result.size();
      for (int s =0;s<=max-1;s++) {
        ArrayList<Integer> n = new ArrayList<Integer>();
        for (Integer j : result.get(s)) {
          n.add(j);
        }
        n.add(num[i]);
        result.add(n);
      }
    }
    for (int i = 0; i <= result.size() - 1; i++) {
      for (int j = i + 1; j <= result.size()-1; j++) {
        ArrayList<Integer> m = result.get(i);
        ArrayList<Integer> n = result.get(j);
        boolean same = true;
        if (m.size() == n.size()) {
          for (int k = 0; k <= m.size() - 1; k++) {
            //int aa = m.get(k);
            //int bb = n.get(k);
            if (m.get(k) != n.get(k)) {
              same = false;
              break;
            }
          }
          if (same) {
            result.remove(j);
            j--;
          }
        }
      }
    }
    return result;
  }
}
