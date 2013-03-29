package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public static void main(String args[]) {
    int k = 33;
    ArrayList<Integer> result = new PascalTriangle().getRow(k);
    System.out.print("[ ");
    for (Integer i : result) {
      System.out.print(i + " ");
    }
    System.out.print("]");
  }

  public ArrayList<Integer> getRow(int rowIndex) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; i++) {
      result.add(0);
    }
    result.set(0, 1);
    for (int i = 1; i <= rowIndex - 1; i++) {
      result.set(i, 1);
      for (int j = i; j >= 1; j--) { // calculate this from back to front,
        // in case that the value of last line modify itself before being use.
        int item = result.get(j - 1) + result.get(j);
        result.set(j, item);
      }
    }
    result.set(rowIndex, 1);
    return result;
  }
}
