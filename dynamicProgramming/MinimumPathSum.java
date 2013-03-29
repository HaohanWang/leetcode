package dynamicProgramming;

public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = grid.length;
    if (m == 0)
      return 0;
    int n = grid[0].length;
    if (n == 0)
      return 0;
    int[][] sum = new int[grid.length][grid[0].length];
    sum[0][0] = grid[0][0];
    for (int i = 1; i <= m - 1; i++) {
      sum[i][0] = sum[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j <= n - 1; j++) {
      sum[0][j] = sum[0][j - 1] + grid[0][j];
    }
    for (int i = 1; i <= m - 1; i++) {
      for (int j = 1; j <= n - 1; j++) {
        sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
      }
    }
    return sum[m - 1][n - 1];
  }
}
