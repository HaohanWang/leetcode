package array;

public class Search2DMatrix {
  /**
   * Again, binary search
   * @param matrix
   * @param target
   * @return
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (matrix.length == 0)
      return false;
    int s = 0, e = matrix.length - 1;
    while (s <= e) {
      int m = e + (s - e) / 2;
      if (matrix[m][0] == target)
        return true;
      if (matrix[m][0] < target) {
        s = m + 1;
      } else {
        e = m - 1;
      }
    }
    if (e < 0)
      return false;
    int n = e;
    s = 0;
    e = matrix[0].length - 1;
    while (s <= e) {
      int m = e + (s - e) / 2;
      if (matrix[n][m] == target)
        return true;
      if (matrix[n][m] < target) {
        s = m + 1;
      } else {
        e = m - 1;
      }
    }
    return false;
  }
}
