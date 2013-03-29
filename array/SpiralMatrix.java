package array;    

import java.util.ArrayList;

public class SpiralMatrix {
  /**
   * Recursive implementation.            
   * @param matrix
   * @param x
   * @param y
   * @param m
   * @param n
   * @return
   */
  
  public ArrayList<Integer> spiralOrder(int[][] matrix, int x, int y, int m, int n) {
    ArrayList<Integer> seq = new ArrayList<Integer>();

    if (m <= 0 || n <= 0) {
      return seq;
    }

    // be careful of the 4 corners, do not duplicate them
    // top side
    for (int j = y; j < y + n; j++) {
      seq.add(matrix[x][j]);
    }
    // right side
    for (int i = x + 1; i < x + m - 1; i++) {
      seq.add(matrix[i][y + n - 1]);
    }

    // bot side
    if (m > 1) {
      for (int j = y + n - 1; j >= y; j--) {
        seq.add(matrix[x + m - 1][j]);
      }
    }

    // left side
    if (n > 1) {
      for (int i = x + m - 2; i > x; i--) {
        seq.add(matrix[i][y]);
      }
    }
    seq.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));

    return seq;
  }

  public static void main(String args[]) {
    int[][] matrix = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };
    System.out.println(new SpiralMatrix().spiralOrder(matrix));
  }

  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    // Start typing your Java solution below
    // DO NOT write main() function
    boolean[][] flag = new boolean[matrix.length][matrix[0].length];
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return result;
    }
    int total = matrix.length * matrix[0].length;
    int i = 0;
    int j = 0;
    int count = 0;
    while (count < total) {
      count++;
      result.add(matrix[i][j]);
      flag[i][j] = true;
      int[] next = getNext(i, j, matrix, flag);
      i = next[0];
      j = next[1];
    }
    return result;
  }

  public int[] getNext(int a, int b, int[][] matrix, boolean[][] flag) {
    // int d = 0;// 1 for right, 2 for down, 3 for left, 4 for up
    int[] next = new int[2];
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;
    if (a <= m / 2 && b < n / 2) {
      if (a <= b) {
        next[0] = a;
        next[1] = b + 1;
      } else {
        next[0] = a - 1;
        next[1] = b;
      }
    } else if (a <= m / 2 && b >= n / 2) {
      if (b >= n - a) {
        next[0] = a + 1;
        next[1] = b;
      } else {
        next[0] = a;
        next[1] = b + 1;
      }
    } else if (a > m / 2 && b > n / 2) {
      if (b - a > n - m) {
        next[0] = a + 1;
        next[1] = b;
      } else {
        next[0] = a;
        next[1] = b - 1;
      }
    } else {
      if (b + a <= m) {
        next[0] = a - 1;
        next[1] = b;
      } else {
        next[0] = a;
        next[1] = b - 1;
      }
    }
    return next;
  }
}
