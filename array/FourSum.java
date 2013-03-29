package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
/**
 * @deprecated
 * Cannot handle if there are two of them with same value
 * 
 * @author haohanwang
 *
 */
public class FourSum {
  public static void main(String args[]) {
    int[] num = {-3,-2,-1,0,0,1,2,3};
    int target = 0;
    System.out.println(new FourSum().fourSum(num, target));
  }

  class TwoSum implements Comparator {
    int sum;

    int i;

    int j;

    TwoSum(int sum, int i, int j) {
      this.sum = sum;
      this.i = i;
      this.j = j;
    }

    public TwoSum() {
      // TODO Auto-generated constructor stub
    }

    @Override
    public int compare(Object o1, Object o2) {
      TwoSum t1 = (TwoSum) o1;
      TwoSum t2 = (TwoSum) o2;
      if (t1.sum != t2.sum) {
        return t1.sum - t2.sum;
      } else if (t1.i != t2.i) {
        return t1.i - t2.i;
      } else
        return t1.j - t2.j;
    }

    @Override
    public boolean equals(Object o1) {
      if (this.sum == ((TwoSum) o1).sum)
        return true;
      return false;
    }
  }

  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<TwoSum> sum = new ArrayList<TwoSum>();
    if (num.length <= 3) {
      return result;
    }
    for (int i = 0; i <= num.length - 1; i++) {
      for (int j = i + 1; j <= num.length - 1; j++) {
        TwoSum ts = new TwoSum(num[i] + num[j], i, j);
        sum.add(ts);
      }
    }
    // Collections.sort(sum, new TwoSum());
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 0; i <= sum.size() - 1; i++) {
      if (hm.containsKey(sum.get(i).sum)) {
        TwoSum s = sum.get(i);
        TwoSum t = sum.get(hm.get(sum.get(i).sum));
        if (s.i != t.i && s.i != t.j && s.j != t.i && s.j != t.j) {
          ArrayList<Integer> a = new ArrayList<Integer>();
          a.add(num[s.i]);
          a.add(num[s.j]);
          a.add(num[t.i]);
          a.add(num[t.j]);
          Collections.sort(a);
          if (!result.contains(a)) {
            result.add(a);
          }
        }
      } else {
        hm.put(target - sum.get(i).sum, i);
      }
    }
    return result;
  }
}
