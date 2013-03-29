package string;

public class WordSearch {
  public static void main(String args[]) {
    String[] a = { "ab" };
    String word = "ab";
    char[][] board = new char[a.length][a[0].length()];
    for (int i = 0; i <= board.length - 1; i++) {
      for (int j = 0; j <= board[0].length - 1; j++) {
        board[i][j] = a[i].charAt(j);
      }
    }
    System.out.println(new WordSearch().exist(board, word));
  }

  /**
   * A basically equal implementation is that we can use a global flag to mark visited.
   * then we need to change the visit flag each time. 
   * 
   * @param board
   * @param word
   * @return
   */

  public boolean exist(char[][] board, String word) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (board.length == 0)
      return false;
    if (word.length() == 0)
      return false;
    for (int i = 0; i <= board.length - 1; i++) {
      for (int j = 0; j <= board[0].length - 1; j++) {
        if (word.charAt(0) == board[i][j]) {
          if (find(board, word, i, j))
            return true;
        }
      }
    }
    return false;
  }

  public boolean find(char[][] board, String word, int i, int j) {
    boolean[][] flag = new boolean[board.length][board[0].length];
    int index = 0;
    return find(board, flag, index, word, i, j);
  }

  public boolean find(char[][] board, boolean[][] flag, int index, String word, int i, int j) {
    if (index == word.length() - 1) {
      if (word.charAt(index) == board[i][j])
        return true;
      else
        return false;
    }
    if (word.charAt(index) == board[i][j]) {
      flag[i][j] = true;
      if (i >= 1) {
        if (flag[i - 1][j] == false) {
          if (find(board, flag, index + 1, word, i - 1, j))
            return true;
        }
      }
      if (i + 1 <= board.length - 1) {
        if (flag[i + 1][j] == false) {
          if (find(board, flag, index + 1, word, i + 1, j))
            return true;
        }
      }
      if (j >= 1) {
        if (flag[i][j - 1] == false) {
          if (find(board, flag, index + 1, word, i, j - 1))
            return true;
        }
      }
      if (j + 1 <= board[0].length - 1) {
        if (flag[i][j + 1] == false) {
          if (find(board, flag, index + 1, word, i, j + 1))
            return true;
        }
      }
    }
    return false;
  }
}
