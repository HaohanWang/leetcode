package array;

public class MergeSortedArray {
  public static void main(String args[]){
    int [] A = new int [1000];
    int [] B = new int [100];
    for (int i=0;i<=10;i++){
      A[i]=i*2;
      B[i]=i*2+7;
    }
    new MergeSortedArray().merge(A, 11, B, 11);
    for (int i=0;i<=21;i++){
      System.out.print(" "+A[i]);
    }
   }
  
  public void merge(int A[], int m, int B[], int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (m == 0) {
      int i = 0;
      while (i < n) {
        A[i] = B[i++];
      }
    }
    if (n != 0) {
      int[] r = new int[m + n];
      int i = 0, j = 0;
      while (i < m && j < n) {
        if (A[i] <= B[j]) {
          r[i + j] = A[i++];
        } else {
          r[i + j] = B[j++];
        }
      }
      while (i < m) {
        r[i + j] = A[i++];
      }
      while (j < n) {
        r[i + j] = B[j++];
      }
      for (i = 0; i <= m + n - 1; i++) {
        A[i] = r[i];
      }
    }
  }
}
