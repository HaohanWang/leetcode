package array;

public class SpiralMatrixII {
  public static void main(String args[]){
    int n=15;
    int [][] matrix = new SpiralMatrixII().generateMatrix(n);
    for (int i=0;i<=n-1;i++){
      for (int j=0;j<=n-1;j++){
        System.out.print(matrix[i][j]+"\t");
      }
      System.out.println();
    }
  }
  
  public int[][] generateMatrix(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[][] matrix = new int[n][n];
    boolean[][] flag = new boolean[n][n];
    int[] d = new int[2];
    d[0] = 0;
    d[1] = 1;
    int count = 1;
    int[] p = new int[2];
    p[0] = 0;
    p[1] = -1;
    while (count <= n * n) {
      p = getNext(p, d, flag);
      matrix[p[0]][p[1]] = count++;
      flag[p[0]][p[1]] = true;
    }
    return matrix;
  }

  int[] getNext(int[] p, int[] d, boolean[][] flag) {
    if (p[0] + d[0] >= 0 && p[0] + d[0] <= flag.length - 1 && p[1] + d[1] >= 0
            && p[1] + d[1] <= flag[0].length - 1) {
      if (flag[p[0] + d[0]][p[1] + d[1]] == false) {
        p[0] += d[0];
        p[1] += d[1];
        return p;
      } else {
        return turnRight(p, d);
      }
    }
    return turnRight(p, d);
  }

  int[] turnRight(int[] p, int[] d) {
    int i=d[0];
    int j=d[1];
    if (d[0] == 0)
      d[0] = j;
    else
      d[0] = 0;
    if (d[1] == 0)
      d[1] = -i;
    else
      d[1] = 0;
    p[0] += d[0];
    p[1] += d[1];
    return p;
  }
}
