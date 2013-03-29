package string;

import java.util.ArrayList;
import java.util.Arrays;

public class StringWithConcatationofAllWords {
  public static void main(String args[]) {
    String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
    String[] L = { "fooo", "barr", "wing", "ding", "wing" };
    System.out.println(new StringWithConcatationofAllWords().findSubstringBetter(S, L));
  }

  public ArrayList<Integer> findSubstring(String S, String[] L) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (L.length == 0 || S.length() == 0) {
      return result;
    }
    int l = L.length * L[0].length();
    for (int i = 0; i <= S.length() - l; i++) {
      if (findIt(S.substring(i, i + l), L)) {
        result.add(i);
      }
    }
    return result;
  }

  public boolean findIt(String S, String[] L) {
    boolean[] flag = new boolean[L.length];
    int l = L[0].length();
    for (int i = 0; i <= S.length() - l; i += l) {
      for (int j = 0; j <= L.length - 1; j++) {
        if (L[j].equals(S.substring(i, i + l)) && flag[j] == false) {
          flag[j] = true;
          break;
        }
      }
    }
    for (int j = 0; j <= L.length - 1; j++) {
      if (flag[j] == false) {
        return false;
      }
    }
    return true;
  }

  /**
   * http://computationalpuzzles.wordpress.com/2011/11/17/substring-with-concatenation-of-all-words-in-a-list/ 
   * This is a much better solution!! Linear time. 
   * For this kind of problems, we need to think about queue to maintain that each one appears only once and continuously.
   * First, we can try to find where each substring can start first, in linear time. 
   */
  public ArrayList<Integer> findSubstringBetter(String S, String[] L) {
    // Start typing your Java solution below
    // DO NOT write main() function

    ArrayList<Integer> ret = new ArrayList<Integer>();
    if (L.length == 0) {
      return ret;
    }

    // I will create another string array without the duplcates
    ArrayList<String> l = new ArrayList<String>();
    ArrayList<Integer> c = new ArrayList<Integer>();

    Arrays.sort(L);
    for (int i = 0; i < L.length; i++) {
      l.add(L[i]);
      int count = 1;
      while (i + 1 < L.length && L[i].equals(L[i + 1])) {
        i++;
        count++;
      }
      c.add(count);
    }

    int[] starts = new int[S.length()];

    for (int i = 0; i < S.length(); i++) {
      starts[i] = -1;
      for (int j = 0; j < l.size(); j++) {
        if (S.substring(i).startsWith(l.get(j))) {
          starts[i] = j;
        }
      }
    }

    int step = L[0].length();

    for (int i = 0; i <= S.length() - step * L.length; i++) {
      int[] perm = new int[L.length];
      boolean needTest = true;
      for (int j = 0; j < L.length; j++) {
        perm[j] = starts[i + j * step];
        if (perm[j] == -1) {
          needTest = false;
        }
      }
      if (needTest && testPerm(perm, c)) {
        ret.add(i);
      }
    }

    return ret;
  }

  private boolean testPerm (int[] perm, ArrayList<Integer> c) {
    int[] count = new int[c.size()];
    for (int i = 0; i < count.length; i++) {
        count[i] = 0;
    }

    for (int i = 0; i < perm.length; i++) {
        count[perm[i]]++;
    }

    for (int i = 0; i < count.length; i++) {
        if (count[i] != c.get(i)) {
            return false;
        }
    }

    return true;
}
}
