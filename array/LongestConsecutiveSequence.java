package array;

import java.util.HashMap;

public class LongestConsecutiveSequence {
  public static void main(String args[]) {
    int[] num = {0, -1};
    System.out.println(new LongestConsecutiveSequence().longestConsecutive(num));
  }

  public int longestConsecutive(int[] num) {
    if (num.length == 0)
      return 0;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int max = 0;
    for (int i = 0; i <= num.length - 1; i++) {
      if (!hm.containsKey(num[i])) {
        hm.put(num[i], num[i]);
        max = Math.max(max, 1);
        int index = num[i];
        if (hm.containsKey(num[i] - 1)) {
          index = hm.get(num[i] - 1);
          hm.remove(num[i]);
          hm.put(num[i], index);
          max = Math.max(max, num[i] - index + 1);
        }
        int j = 1;
        while (hm.containsKey(num[i] + j)) {
          hm.remove(num[i] + j);
          hm.put(num[i] + j, index);
          max = Math.max(max, num[i] + j - index + 1);
          j++;
        }
      }
    }
    return max;
  }
}
