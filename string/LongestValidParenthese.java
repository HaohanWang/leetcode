package string;

public class LongestValidParenthese {
  public static void main(String args[]) {
    String s ="(()(((())))()";
    System.out.println(new LongestValidParenthese().longestValidParentheses(s));
  }
  /**
   * we need to think through all the possibilities.
   * Remember that as long as there is a pattern, there is a solution. 
   * Don't always try to use lazy ways. 
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int lastL = -1;
    if (s.length() <= 1) {
      return 0;
    }
    int max = 0;
    boolean[] newL = new boolean[s.length()];
    boolean[] suc = new boolean[s.length()];
    int[] len = new int[s.length()];
    if (s.charAt(0) == '(') {
      lastL = 0;
      newL[0] = true;
      len[0] = 0;
    }
    for (int i = 1; i <= s.length() - 1; i++) {
      if (s.charAt(i) == '(') {
        lastL = i;
        newL[i] = true;
        if (suc[i - 1]) {
          len[i] = len[i - 1];
        } else {
          len[i] = i;
        }
      } else {
        if (lastL != -1) {
          max = Math.max(max, i - len[lastL] + 1);
          newL[lastL] = false;
          suc[lastL] = true;
          suc[i] = true;
          len[i] = len[lastL];
          int temp = lastL;
          lastL = -1;
          for (int j = temp - 1; j >= 0; j--) {
            if (s.charAt(j) == '(' && newL[j] == true) {
              lastL = j;
              break;
            }
          }
        }
      }
    }
    return max;
  }
}
