package string;

import java.util.ArrayList;

public class GrayCodeII {
  // better solution
  public int binarytoGray(int num) {
    return (num >> 1) ^ num;
  }
  //////////////////////////////////////////
  public static void main(String args[]) {
    int n = 11;
    System.out.println(new GrayCodeII().grayCode(n));
  }

  public ArrayList<Integer> grayCode(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    int num = 0;
    int mask = 1;
    result.add(0);
    for (int i = 0; i <= Math.pow(2, n) - 2; i++) {
      mask = 1;
      int temp = mask ^ num;
      while (result.contains(temp)) {
        mask = mask << 1;
        temp = mask ^ num;
      }
      result.add(temp);
      num = temp;
    }
    return result;
  }
}
