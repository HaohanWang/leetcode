package array;

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] numbers, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] result = new int[2];
    HashMap<Integer, Integer> t = new HashMap<Integer, Integer>(numbers.length);
    for (int i = 0; i <= numbers.length - 1; i++) {
      if (t.containsKey(numbers[i])) {
        result[0] = t.get(numbers[i]);
        result[1] = i;
        return result;
      } else {
        t.put(target - numbers[i], i);
      }
    }
    return result;
  }
}
