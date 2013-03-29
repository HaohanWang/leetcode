package array;

public class ContainerWithMostWater {
  /**
   * Fancinating algorithm
   * This is different from traditional DP since they move two pointers. 
   * I have not seen much more algorithms about moving two pointers. 
   * @param height
   * @return
   */
  public int maxArea(int[] height) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (height.length == 0)
      return 0;
    int max = 0;
    int l = 0;
    int r = height.length - 1;
    while (l < r) {
      max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
      if (height[l] >= height[r]) {
        r--;
      } else {
        l++;
      }
    }
    return max;
  }
}
