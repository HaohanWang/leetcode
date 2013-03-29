package array;

public class JumpGame {
  /**
   * A very good O(n) solution
   * @param A
   * @return
   */
  public boolean canJump(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length == 0) {
      return false;
    }
    if (A.length == 1) {
      return true;
    }
    boolean psb = false;
    int count = 0;

    for (int i = A.length - 2; i >= 0; i--) {
      if (A[i] > count) {// you can go from a[i] to the nearest point that's connected to the last
                         // one
        psb = true; // it is possible to reach the end if you ever arrive at a[i]
        count = 0;
      } else {
        psb = false;
        count++; // count is the number you should be bigger than so that you can go to nearest
                 // 'train station'
      }
    }

    return psb;
  }
}
