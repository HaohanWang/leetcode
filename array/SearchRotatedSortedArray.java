package array;

public class SearchRotatedSortedArray {
  public static void main(String args[]) {
    int[] A = { 2, 4, 7, 9, 0 };
    int target = 9;
    System.out.println(new SearchRotatedSortedArray().search(A, target));
  }

  public int search(int[] A, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int l = 0, r = A.length - 1;
    int m = 0;
    while (l <= r) {
      m = r + (l - r) / 2;
      if (A[m] == target) {
        return m;
      }
      if (A[l] <= A[m]) {
        if (A[m] > target && A[l] <= target) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        if (A[m] < target && A[r] >= target) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }
    return -1;
  }
}
