package string;

public class LongestPanlindromeSubstring {
  public static void main(String args[]){
    String m ="bb";
    System.out.println(new LongestPanlindromeSubstring().longestPalindrome(m));
  }
  /**
   * Pay attention to the O(N) algorithm
   * @param s
   * @return
   */
  
  public String longestPalindrome(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int max = 0;
    int index = 0;
    for (int i = 0; i <= s.length() - 1; i++) {
      int m = findPalindrome(s, i);
      if (max < m) {
        index = i;
        max = m;
      }
    }
    if (max % 2 == 0) {
      return s.substring(index + 1 - max / 2, index + 1 + max / 2);
    } else {
      return s.substring(index - max / 2, index + 1 + max / 2);
    }
  }

  public int findPalindrome(String s, int index) {
    int max = 1;
    int i = index - 1, j = index + 1;
    while (i >= 0 && j <= s.length() - 1) {
      if (s.charAt(i--) == s.charAt(j++)) {
        max += 2;
      } else {
        break;
      }
    }
    int max2 = 0;
    i = index;
    j = index + 1;
    while (i >= 0 && j <= s.length() - 1) {
      if (s.charAt(i--) == s.charAt(j++)) {
        max2 += 2;
      } else {
        break;
      }
    }
    return Math.max(max, max2);
  }
}
