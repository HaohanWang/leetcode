package array;

public class ValidSudoku {
  public static void main(String args[]) {
    String[] b = { ".1...1...", ".........", ".........", ".........", ".........", ".........",
        ".........", ".........", "........." };
    char[][] board = new char[9][9];
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        board[i][j] = b[i].charAt(j);
      }
    }
    System.out.println(new ValidSudoku().isValidSudoku(board));
  }

  public boolean isValidSudoku(char[][] board) {
    // Start typing your Java solution below
    // DO NOT write main() function
    for (int i = 0; i <= board.length - 1; i++) {
      boolean[] h = new boolean[board[0].length];
      boolean[] v = new boolean[board.length];
      for (int j = 0; j <= board[0].length - 1; j++) {
        if (board[i][j] != '.') {
          if (h[board[i][j] - '1'] == true) {
            return false;
          } else
            h[board[i][j] - '1'] = true;
        }
        if (board[j][i] != '.') {
          if (v[board[j][i] - '1'] == true) {
            return false;
          } else
            v[board[j][i] - '1'] = true;
        }
      }
    }
    for (int i = 0; i <= board.length - 1; i += 3) {
      for (int j = 0; j <= board[0].length - 1; j += 3) {
        if (!checkSquare(i, j, board))
          return false;
      }
    }
    return true;
  }

  public boolean checkSquare(int a, int b, char[][] board) {
    boolean[] s = new boolean[9];
    for (int i = a; i <= a + 2; i++) {
      for (int j = b; j <= b + 2; j++) {
        if (board[i][j] != '.') {
          if (s[board[i][j] - '1'] == true) {
            return false;
          } else
            s[board[i][j] - '1'] = true;
        }
      }
    }
    return true;
  }
}
