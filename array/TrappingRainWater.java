package array;

public class TrappingRainWater {
  public static void main(String args[]) {
    int[] A = { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };
    System.out.println(new TrappingRainWater().trap(A));
  }

  public int trap(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int water = 0;
    int total = 0;
    int height = 0;
    int[] hold = new int[2];
    int h = 0;
    int H = 0;
    for (int i = 0; i <= A.length - 1; i++) {
      H = Math.max(H, A[i]);
    }
    while (height < H + 1) {
      water = 0;
      height++;
      h = 0;
      int count = 0;
      for (int i = 0; i <= A.length - 1; i++) {
        if (A[i] >= height) {
          hold[h] = i;
          h = (h + 1) % 2;
          count++;
          if (count >= 2) {
            water += Math.abs(hold[h] - hold[(h + 1) % 2]) - 1;
          }
        }
      }
      total += water;
    }
    return total;
  }

  /*
   * 算法很简单，核心思想是：对某个值A[i]来说，能trapped的最多的water取决于在i之前最高的值leftMostHeight[i]和在i右边的最高的值rightMostHeight[i]
   * 。（均不包含自身）。如果min(left,right) > A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
   * 
   * 有了这个想法就好办了，第一遍从左到右计算数组leftMostHeight，第二遍从右到左计算rightMostHeight，在第二遍的同时就可以计算出i位置的结果了，
   * 而且并不需要开空间来存放rightMostHeight数组。
   * 
   * 时间复杂度是O(n)，只扫了两遍
   * 
   * 
   * class Solution {
public:
    int trap(int A[], int n) {
        //no way to contain any water
        if(n <= 2) return 0;
        
        //1. first run to calculate the heiest bar on the left of each bar
        int *lmh = new int[n];//for the most height on the left
        lmh[0] = 0;
        int maxh = A[0];
        for(int i = 1; i < n; ++i) {
            lmh[i] = maxh;
            if(maxh < A[i]) maxh = A[i];
        }
        int trapped = 0;
        
        //2. second run from right to left, 
        // caculate the highest bar on the right of each bar
        // and calculate the trapped water simutaniously
        maxh = A[n-1];
        for(int i = n - 2; i > 0; --i) {
            int left = lmh[i];
            int right = maxh;
            int container = min(left,right);
            if(container > A[i]) {
                trapped += container - A[i];
            }
            if(maxh < A[i]) maxh = A[i];
        }
        delete lmh;
        return trapped;
    }
};
   */
}
