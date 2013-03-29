package dynamicProgramming;

public class EditDistance {
  public int minDistance(String word1, String word2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (word1.length() == 0)
      return word2.length();
    if (word2.length() == 0)
      return word1.length();
    int[][] r = new int[word2.length()][word1.length()];
    if (word1.charAt(0) == word2.charAt(0)) {
      r[0][0] = 0;
    } else
      r[0][0] = 1;
    for (int j = 1; j <= word1.length() - 1; j++) {
      if (word2.charAt(0) == word1.charAt(j)) {
        r[0][j] = r[0][j - 1];
      } else {
        r[0][j] = r[0][j - 1] + 1;
      }
    }
    for (int i = 1; i <= word2.length() - 1; i++) {
      if (word1.charAt(0) == word2.charAt(i)) {
        r[i][0] = r[i - 1][0];
      } else {
        r[i][0] = r[i - 1][0] + 1;
      }
    }
    for (int i = 1; i <= word2.length() - 1; i++) {
      for (int j = 1; j <= word1.length() - 1; j++) {
        if (word1.charAt(j) == word2.charAt(i)) {
          r[i][j] = r[i - 1][j - 1];
        } else {
          r[i][j] = r[i - 1][j - 1] + 1;
        }
        r[i][j] = Math.min(r[i][j], r[i - 1][j] + 1);
        r[i][j] = Math.min(r[i][j], r[i][j - 1] + 1);
      }
    }
    return r[word2.length() - 1][word1.length() - 1];
  }
}
