package array;

/**
 * This is complicated
 * Traceback algorithm is not difficult, however, the difficult part is how to control the traceback.
 * There are plenty of minor mistakes
 * @author haohanwang
 *
 */


public class SudokuSolver {
  public static void main(String args[]) {
    //String [] b = {".........",".........",".........",".........",".........",".........",".........",".........","........."};
    String[] b = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.." };
    char[][] board = new char[9][9];
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        board[i][j] = b[i].charAt(j);
      }
    }
    new SudokuSolver().solveSudoku(board);
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  public void solveSudoku(char[][] board) {
    // Start typing your Java solution below
    // DO NOT write main() function
    boolean[][] blank = new boolean[9][9];
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        if (blank[i][j] == true) {
          board[i][j] += 1;       
          while (board[i][j] <= '9' && !check(i, j, board)) {
            board[i][j] += 1;
          }
          if (board[i][j] > '9') {
            board[i][j] = '.';
            blank[i][j] = false;
            int[] back = trackBack(i, j, blank);
            i = back[0];
            j = back[1];
          }
          //printBoard(board);
        }
        if (j!=-1&&board[i][j] == '.') {
          blank[i][j] = true;
          board[i][j] = '1';
          while (board[i][j] <= '9' && !check(i, j, board)) {
            board[i][j] += 1;
          }
          if (board[i][j] > '9') {
            board[i][j] = '.';
            blank[i][j] = false;
            int[] back = trackBack(i, j, blank);
            i = back[0];
            j = back[1];
          }
          //printBoard(board);
        }
      }
    }
  }

  public int[] trackBack(int a, int b, boolean[][] blank) {
    int[] back = new int[2];
    boolean find = false;
    for (int i = a; i >= 0 && !find; i--) {
      for (int j = i==a?b-1:8; j >= 0; j--) {
        if (blank[i][j] == true) {
          back[0] = i;
          back[1] = j - 1;
          find = true;
          break;
        }
      }
    }
    return back;
    // if (back[1] > 0) {
    // back[1] -= 1;
    // return back;
    // } else {
    // back[0] -= 1;
    // back[1] = 8;
    // return back;
    // }
  }

  public boolean check(int a, int b, char[][] board) {
    boolean[] h = new boolean[9];
    boolean[] v = new boolean[9];
    boolean[] s = new boolean[9];
    for (int i = 0; i <= 8; i++) {
      if (board[a][i] != '.') {
        if (h[board[a][i] - '1'] == true) {
          return false;
        } else {
          h[board[a][i] - '1'] = true;
        }
      }
      if (board[i][b] != '.') {
        if (v[board[i][b] - '1'] == true) {
          return false;
        } else {
          v[board[i][b] - '1'] = true;
        }
      }
    }
    a = a / 3 * 3;
    b = b / 3 * 3;
    for (int i = a; i <= a + 2; i++) {
      for (int j = b; j <= b + 2; j++) {
        if (board[i][j] != '.') {
          if (s[board[i][j] - '1'] == true) {
            return false;
          } else {
            s[board[i][j] - '1'] = true;
          }
        }
      }
    }
    return true;
  }

  public void printBoard(char[][] board) {
    System.out.println("------------------------");
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println("------------------------");
  }
}
