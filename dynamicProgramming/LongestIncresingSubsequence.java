package dynamicProgramming;

import input.RandomNumber;

public class LongestIncresingSubsequence {
  public int findLongestIncreasingSubsequenceContiguously(int[] array) {
    int[] result = new int[array.length];
    for (int i = 0; i <= array.length - 1; i++) {
      result[i] = i;
    }
    int max = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      if (array[i] < array[i + 1]) {
        result[i] = result[i + 1];
      }
      if (result[i] - i + 1 > max) {
        max = result[i] - i + 1;
      }
    }
    return max;
  }

  public static void main(String args[]) {
    int[] random = new RandomNumber().generateRandomNumber(0, 30);
    for (int i = 0; i <= 29; i++) {
      System.out.print(random[i] + " ");
    }
    System.out.println("\n"
            + new LongestIncresingSubsequence()
                    .findLongestIncreasingSubsequenceIncontinuously(random));
  }

  public int findLongestIncreasingSubsequenceIncontinuously(int[] array) {
    /*
     * Better algorihtm, only N(logn)
     * 
     * See: http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
     *
     * sz = 1; c[1] = array[0]; /*at this point, the minimum value of the last element of the size 1
     * increasing sequence must be array[0] 
     * dp[0] = 1; 
     * for( int i = 1; i < len; i++ ) 
     * { 
     *      if( array[i] < c[1] ) 
     *      { 
     *          c[1] = array[i]; /*you have to update the minimum value right now 
     *          dp[i] = 1; 
     *      }
     *      else if( array[i] > c[sz] ) 
     *      { 
     *          c[sz+1] = array[i]; 
     *          dp[i] = sz+1; sz++; 
     *      } 
     *      else 
     *      { 
     *          int k = binary_search( c, sz, array[i] ); /*you want to find k so that c[k-1]<array[i]<c[k] 
     *          c[k] = array[i]; dp[i] = k; 
     *      } 
     * }
     */
    int[] result = new int[array.length];
    int[] count = new int[array.length];
    for (int i = 0; i <= array.length - 1; i++) {
      result[i] = i;
      count[i] = 1;
    }
    int max = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      for (int j = i + 1; j <= array.length - 1; j++) {
        if (array[i] < array[j]) {
          result[i] = result[j];
          count[i] += count[j];
          if (count[i] > max) {
            max = count[i];
          }
          break;
        }
      }
    }
    return max;
  }

}
