package string;

public class MinimumWindowSubstring {
  public static void main(String args[]){
    String S = "acbbaca";
    String T = "aba";
    System.out.println(new MinimumWindowSubstring().minWindow(S, T));
  }
  /**
   * Great Algorithm!!!
   * When we need O(n) for string, we can think of this. 
   * Move the end of window and let the begin of window go to catch it. 
   * @param S
   * @param T
   * @return
   */
  
  
  
  public String minWindow(String S, String T) {
    // Start typing your Java solution below
    // DO NOT write main() function
    String r = "";
    int length = S.length() + 1;
    if (S.length() == 0 || T.length() == 0)
      return r;
    int[] needToFind = new int[256];
    int[] hasFound = new int[256];
    int count = 0;
    for (int i = 0; i <= T.length() - 1; i++) {
      needToFind[T.charAt(i)] += 1;
    }
    int b = 0, e = 0;
    while (e != S.length()) {
      count = findWindow(e, S, needToFind, hasFound, count);
      if (count == T.length()) {
        if (e - b + 1 < length) {
          length = e - b + 1;
          r = S.substring(b, e + 1);
        }
        b = moveBeginPointer(b, S, needToFind, hasFound);
        if (e - b + 1 < length) {
          length = e - b + 1;
          r = S.substring(b, e + 1);
        }
      }
      e++;
    }
    return r;
  }

  public int findWindow(int e, String S, int[] needToFind, int[] hasFound, int count) {
    hasFound[S.charAt(e)]++;
    if (hasFound[S.charAt(e)] <= needToFind[S.charAt(e)]) {

      return count + 1;
    } else {
      return count;
    }
  }

  public int moveBeginPointer(int b, String S, int[] needToFind, int[] hasFound) {
    boolean go = true;
    while (go) {
      if (hasFound[S.charAt(b)] > needToFind[S.charAt(b)]) {
        hasFound[S.charAt(b++)]--;
      } else {
        go = false;
      }
    }
    return b;
  }
}
