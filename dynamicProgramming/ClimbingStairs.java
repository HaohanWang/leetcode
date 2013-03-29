package dynamicProgramming;

public class ClimbingStairs {
  public int climbStairs(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (n <= 2)
      return n;
    int[] w = new int[n];
    w[0] = 1;
    w[1] = 2;
    for (int i = 2; i <= n - 1; i++) {
      w[i] = w[i - 1] + w[i - 2];
    }
    return w[n - 1];
  }
}
