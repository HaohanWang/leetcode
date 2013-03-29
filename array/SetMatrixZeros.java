package array;

public class SetMatrixZeros {
  /**
   * costant space for setMatrixtoZeros.
   * It is easy to think a O(m+n) space solution, 
   * but for constant space, we need to use itself to store itself. 
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int row = -1, col=-1;
    for (int i=0;i<=m-1;i++){
      for (int j=0;j<=n-1;j++){
        if (matrix[i][j]==0){
          row = i;
          col = j;
          j=n;
          i=m;
        }
      }
    }
    if (row==-1)
        return;
    for (int i=row;i<=m-1;i++){
      for (int j=0;j<=n-1;j++){
        if (matrix[i][j]==0){
          matrix[i][col]=0;
          matrix[row][j]=0;
        }
      }
    }
    for (int i=0;i<=m-1;i++){
      if (matrix[i][col]==0&&i!=row){
        for (int j=0;j<=n-1;j++){
          matrix[i][j]=0;
        }
      }
    }
    for (int j=0;j<=n-1;j++){
      if (matrix[row][j]==0&&j!=col){
        for (int i=0;i<=m-1;i++){
          matrix[i][j]=0;
        }
      }
    }
    for (int i=0;i<=m-1;i++){
      matrix[i][col]=0;
    }
    for (int j=0;j<=n-1;j++){
      matrix[row][j]=0;
    }
  }
}
