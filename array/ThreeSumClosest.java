package array;

import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (num.length == 0) {
      return 0;
    }
    int result = 0;
    int abs = Integer.MAX_VALUE;
    Arrays.sort(num);
    for (int i = 0; i <= num.length - 1; i++) {
      int j = i + 1, k = num.length - 1;
      while (j < k) {
        int sum = num[i] + num[k] + num[j];
        if (sum == target) {
          return sum;
        } else if (sum < target) {
          if (abs > Math.abs(sum - target)) {
            abs = Math.abs(sum - target);
            result = sum;
          }
          j++;
        } else {
          if (abs > Math.abs(sum - target)) {
            abs = Math.abs(sum - target);
            result = sum;
          }
          k--;
        }
      }
    }
    return result;
  }
}
