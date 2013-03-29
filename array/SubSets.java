package array;

import java.util.ArrayList;
import java.util.Collections;

public class SubSets {
  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int index = 0;
    return subsets(index, S);
  }
/**
 * Pay attention to that, when we get an ArrayList<ArrayList<Integer>> from recursive, 
 * we need to create every ArrayList<Integer> and use addAll() to create new items to add for result.
 * @param index
 * @param S
 * @return
 */
  public ArrayList<ArrayList<Integer>> subsets(int index, int[] S) {
    ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> n = new ArrayList<Integer>();
    if (index == S.length - 1) {
      r.add(n);
      ArrayList<Integer> l = new ArrayList<Integer>();
      l.add(S[index]);
      r.add(l);
      return r;
    } else {
      ArrayList<ArrayList<Integer>> a = subsets(index + 1, S);
      for (ArrayList<Integer> l : a) {
        ArrayList<Integer> nl = new ArrayList<Integer>();
        nl.addAll(l);
        r.add(nl);
        l.add(S[index]);
        Collections.sort(l);
        if (!r.contains(l)) {
          r.add(l);
        }
      }
      return r;
    }
  }
}
