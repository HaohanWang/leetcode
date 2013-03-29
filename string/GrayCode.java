package string;

import java.util.ArrayList;

public class GrayCode {
  public static void main(String args[]) {
    int n = 11;
    System.out.println(new GrayCode().grayCode(n));
  }

  public ArrayList<Integer> grayCode(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(0);
    String b = "";
    for (int i = 0; i <= n - 1; i++) {
      b += "0";
    }
    for (int i = n - 1; i >= 0; i--) {
      b = changeBit(b, i);
      int num = Integer.parseInt(b, 2);
      if (!result.contains(num)) {
        result.add(num);
      }
      for (int j = n - 1; j >= i + 1; j--) {
        b = changeBit(b, j);
        num = Integer.parseInt(b, 2);
        if (!result.contains(num)) {
          result.add(num);
          j=n;
        }
        else{
          b = changeBit(b, j);
        }
      }
    }
    return result;
  }

  public String changeBit(String b, int j) {
    char bit = b.charAt(j);
    if (bit == '0') {
      b = b.substring(0, j) + "1" + b.substring(j + 1, b.length());
    } else {
      b = b.substring(0, j) + "0" + b.substring(j + 1, b.length());
    }
    return b;
  }
}
