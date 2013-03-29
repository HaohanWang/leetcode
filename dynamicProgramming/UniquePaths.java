package dynamicProgramming;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (m == 0)
      return n;
    if (n == 0)
      return m;
    int[][] map = new int[m][n];
    map[0][0] = 1;
    for (int i = 1; i <= m - 1; i++) {
      map[i][0] = 1;
    }
    for (int j = 1; j <= n - 1; j++) {
      map[0][j] = 1;
    }
    for (int i = 1; i <= m - 1; i++) {
      for (int j = 1; j <= n - 1; j++) {
        map[i][j] = map[i - 1][j] + map[i][j - 1];
      }
    }
    return map[m - 1][n - 1];
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (obstacleGrid.length == 0)
      return 0;
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1)
      return 0;
    int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
    map[0][0] = 1;
    for (int i = 1; i <= m - 1; i++) {
      if (obstacleGrid[i][0] != 1) {
        map[i][0] = map[i - 1][0];
      }
    }
    for (int i = 1; i <= n - 1; i++) {
      if (obstacleGrid[0][i] != 1) {
        map[0][i] = map[0][i - 1];
      }
    }
    for (int i = 1; i <= m - 1; i++) {
      for (int j = 1; j <= n - 1; j++) {
        if (obstacleGrid[i][j] != 1) {
          map[i][j] = map[i - 1][j] + map[i][j - 1];
        }
      }
    }
    return map[m - 1][n - 1];
  }
}
