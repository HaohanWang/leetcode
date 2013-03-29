package array;

public class SearchForARange {
  public int[] searchRange(int[] A, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] n = new int[2];
    int l = 0, r = A.length - 1;
    int m = 0;
    double t = target - 0.5;
    while (l <= r) {
      m = r + (l - r) / 2;
      if (A[m] < t)
        l = m + 1;
      else {
        r = m - 1;
      }
    }
    n[0] = l;
    t = target + 0.5;
    r = A.length - 1;
    while (l <= r) {
      m = r + (l - r) / 2;
      if (A[m] < t)
        l = m + 1;
      else {
        r = m - 1;
      }
    }
    n[1] = r;
    if (n[1] < n[0]) {
      n[0] = -1;
      n[1] = -1;
    }
    return n;
  }
}
