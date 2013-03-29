package string;

import java.util.ArrayList;

public class GenerateParenthese {
  public static void main(String args[]) {
    int n = 2;
    System.out.println(new GenerateParenthese().generateParenthesis(n));
  }

  public ArrayList<String> generateParenthesis(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    result.add("");
    int c = 2 * n;
    while (c > 0) {
      ArrayList<String> temp = new ArrayList<String>();
      temp.addAll(result);
      result.clear();
      for (String s : temp) {
        int l = 0, r = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
          if (s.charAt(i) == '(') {
            l += 1;
          } else {
            r += 1;
          }
        }
        if (l < n) {
          result.add(s + "(");
        }
        if (r < l) {
          result.add(s + ")");
        }
      }
      c--;
    }
    return result;
  }
/**
 * A more time saving solution, recursive.
 * pass result in so that we can store.
 * @param n
 * @return
 */
  public ArrayList<String> generateParenthesis2(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function

    ArrayList<String> result = new ArrayList<String>();
    char[] parens = new char[n + n];
    gp(result, 0, 0, n, parens);

    return result;
  }

  public void gp(ArrayList<String> result, int left, int right, int n, char[] parens) {
    if (left == right && left == n) {
      result.add(new String(parens));
      return;
    }

    if (left < n) {
      parens[left + right] = '(';
      gp(result, left + 1, right, n, parens);
    }

    if (right < left) {
      parens[left + right] = ')';
      gp(result, left, right + 1, n, parens);
    }
  }
}
