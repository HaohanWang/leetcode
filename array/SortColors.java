package array;

public class SortColors {
  /**
   * This solution is based on famous DutchFlag Problem.
   * @param A
   */
  public void sortColorsDutchFlag(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int l = 0, r = A.length - 1, i = 0;
    while (i <= r) {
      if (A[i] == 0) {
        swap(A, i, l);
        l++;
        i++;
      } else if (A[i] == 2) {
        swap(A, i, r);
        r--;
      } else {
        i++;
      }
    }
  }

  public void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  /**
   * A very easy implementation of counting sort
   * 
   * @param A
   */
  public void sortColors(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] count = new int[3];
    for (int i = 0; i <= A.length - 1; i++) {
      count[A[i]]++;
    }
    for (int i = 0; i <= A.length - 1; i++) {
      for (int j = 0; j <= 2; j++) {
        if (count[j] > 0) {
          A[i] = j;
          count[j]--;
          break;
        }
      }
    }
  }
}
