package dynamicProgramming;

public class InterveaingString {
  public static void main(String args[]) {
    String a = "aa";
    String b = "ab";
    String c = "abaa";
    System.out.println(new InterveaingString().isInterleave(a, b, c));
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s3.length() == 0) {
      return (s1.length() + s2.length() == 0);
    }
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    if (s1.length() == 0) {
      return s3.equals(s2);
    }
    if (s2.length() == 0) {
      return s3.equals(s1);
    }
    boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
    result[0][0] = true;
    for (int i = 1; i <= s1.length(); i++) {
      if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
        result[i][0] = result[i - 1][0];
      } else
        break;
    }
    for (int i = 1; i <= s1.length(); i++) {
      if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
        result[0][i] = result[0][i - 1];
      } else
        break;
    }
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s3.charAt(i - 1 + j)) {
          result[i][j] = result[i - 1][j] || result[i][j];
        }
        if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
          result[i][j] = result[i][j - 1] || result[i][j];
        }
      }
    }
    return result[s1.length()][s2.length()];
  }
}
