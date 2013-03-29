package string;

import java.util.ArrayList;

public class RegularExpressionMatching {
  public static void main(String args[]) {
    String s = "a";
    String p = "c*b*.";
    System.out.println(new RegularExpressionMatching().isMatch(s, p));
  }
/**
 * However, this regular expression matching is not perfect, but at least meet all the requirements of leetcode
 * @param s
 * @param p
 * @return
 */
  public boolean isMatch(String s, String p) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() == 0) {
      if (p.length() == 0) {
        return true;
      } else {
        if (p.length() % 2 == 1)
          return false;
        boolean star = true;
        for (int t = 1; t <= p.length() - 1; t = t + 2) {
          star = star && (p.charAt(t) == '*');
        }
        return star;
      }
    }
    int i = p.length() - 1;
    int j = s.length() - 1;
    while (i >= 0 && j >= 0) {
      if (p.charAt(i) == s.charAt(j)) {
        i--;
        j--;
      } else {
        if (p.charAt(i) == '.') {
          i--;
          j--;
        } else if (p.charAt(i) == '*') {
          ArrayList<Integer> m = findRecursivePoint(s, p, j, i);
          boolean result = false;
          for (Integer k : m) {
            result = result || isMatch(s.substring(0, k), p.substring(0, i - 1));
          }
          return result;
        } else {
          return false;
        }
      }
    }
    if (i >= 0 || j >= 0) {
      if (j >= 0 && i < 0) {
        return false;
      } else {
        i = i + 1;
        if (i == 0)
          return false;
        boolean star = true;
        for (int t = 1; t <= i; t = t + 2) {
          star = star && (p.charAt(t) == '*');
        }
        return star;
      }
    } else
      return true;
  }

  ArrayList<Integer> findRecursivePoint(String s, String p, int j, int i) {
    ArrayList<Integer> r = new ArrayList<Integer>();
    if (p.charAt(i - 1) == '.') {
      r.add(j + 1);
      for (int t = j; t >= 0; t--) {
        r.add(t);
      }
      return r;
    } else {
      r.add(j + 1);
      for (int t = j; t >= 0; t--) {
        if (s.charAt(t) == p.charAt(i - 1)) {
          r.add(t);
        } else
          break;
      }
      return r;
    }
  }
}
