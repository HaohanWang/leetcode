package array;

public class FirstMissingPositive {
  /**
   * pay attention to think through how to use A.length
   * @param A
   * @return
   */
  public int firstMissingPositive(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length == 0)
      return 1;
    boolean[] m = new boolean[A.length + 1];
    for (int i = 0; i <= A.length - 1; i++) {
      if (A[i] >= 0 && A[i] <= A.length) {
        m[A[i]] = true;
      }
    }
    for (int i = 1; i <= A.length; i++) {
      if (m[i] == false)
        return i;
    }
    return A.length + 1;
  }
}
