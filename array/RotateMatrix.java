package array;

public class RotateMatrix {
  public static void main(String args[]) {
    int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    new RotateMatrix().rotateMatrix(matrix);
    System.out.println("final:");
    for (int i = 0; i <= matrix.length - 1; i++) {
      for (int j = 0; j <= matrix.length - 1; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
  }

  /**
   * Pay attention to when j stops. It should go as far as the line without the final one,
   * because it has already been rotated.
   * 
   * @param matrix
   */
  public void rotateMatrix(int[][] matrix) {
    int n = matrix.length;
    int c = 0, r = 0;
    for (int i = 0; i <= (n - 1) / 2; i++) {
      for (int j = i; j <= n - i - 2; j++) {
        c = i;
        r = j;
        int temp = matrix[c][r];
        matrix[c][r] = matrix[n - 1 - r][c];
        matrix[n - 1 - r][c] = matrix[n - 1 - c][n - 1 - r];
        matrix[n - 1 - c][n - 1 - r] = matrix[r][n - 1 - c];
        matrix[r][n - 1 - c] = temp;
      }
      printMatrix(matrix);
      // int temp = matrix[i][i];
      // matrix[i][i]=matrix[n-1-i][n-1-i];
      // matrix[n-1-i][n-1-i]=temp;
    }
  }

  public void printMatrix(int[][] matrix) {
    System.out.println("-----------------------");
    for (int i = 0; i <= matrix.length - 1; i++) {
      for (int j = 0; j <= matrix.length - 1; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("-----------------------");
  }
}
