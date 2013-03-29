package array;

public class SearchInsertPosition {
  /**
   * Think it through to figure out whether we should return l or r
   * @param A
   * @param target
   * @return
   */
  public int searchInsert(int[] A, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int l = 0, r = A.length - 1;
    int m = 0;
    while (l <= r) {
      m = r + (l - r) / 2;
      if (A[m] == target) {
        return m;
      }
      if (A[m] < target)
        l = m + 1;
      else
        r = m - 1;
    }
    return l;
  }
}
