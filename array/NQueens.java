package array;

import java.util.ArrayList;

public class NQueens {
  public static void main(String args[]) {
    int n = 5;
    ArrayList<String[]> r = new NQueens().solveNQueens(n);
    for (String[] m : r) {
      for (String s : m) {
        System.out.println(s);
      }
      System.out.println("----------------");
    }
    System.out.println("end");
  }

  public ArrayList<String[]> solveNQueens(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String[]> result = new ArrayList<String[]>();
    if (n == 0)
      return result;
    if (n == 1) {
      String[] a = { "Q" };
      result.add(a);
      return result;
    }
    int[] line = new int[n];
    int start=0;
    while (line[0] <= n) {
      for (int i = start; i < n && i >= 0; i++) {
        line[i]++;
        while (line[i] <= n && !check(line)) {
          line[i]++;
        }
        if (line[i] > n) {
          if (i != 0) {
            line[i] = 0;
          }
          i = i - 2;
        }
      }
      //for (int z:line){System.out.print(z);}System.out.println("---------------");
      if (check(line)) {
        result.add(generateResult(line));
      }
      start=n-1;
    }
    return result;
  }

  public boolean check(int[] line) {
    boolean[] flag = new boolean[line.length + 1];
    for (int i = 0; i <= line.length - 1; i++) {
      if (line[i]>line.length){
        return false;
      }
      if (flag[line[i]] == true && line[i] != 0)
        return false;
      flag[line[i]] = true;
    }
    for (int i = 0; i <= line.length - 1; i++) {
      for (int j = i + 1; j <= line.length - 1; j++) {
        if (line[j] != 0 && line[i] != 0 && Math.abs(line[j] - line[i]) == j - i) {
          return false;
        }
      }
    }
    return true;
  }

  public String[] generateResult(int[] line) {
    String[] r = new String[line.length];
    for (int i = 0; i <= line.length - 1; i++) {
      r[i]="";
      for (int j = 1; j < line[i]; j++) {
        r[i] += ".";
      }
      r[i] += "Q";
      for (int j = line[i] + 1; j <= line.length; j++) {
        r[i] += ".";
      }
    }
    return r;
  }
}
