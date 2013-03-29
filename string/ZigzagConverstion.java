package string;

import java.util.LinkedList;

public class ZigzagConverstion {
  public static void main(String args[]){
    String s = "PAYPALISHIRING";
    int n=2;
    System.out.println(new ZigzagConverstion().convert(s, n));
  }
  public String convert(String s, int nRows) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (nRows == 1)
      return s;
    LinkedList<LinkedList<Character>> line = new LinkedList<LinkedList<Character>>();
    for (int i=0;i<nRows;i++){
      LinkedList<Character> c = new LinkedList<Character>();
      line.add(c);
    }
    int m = 2 * nRows - 2;
    for (int i = 0; i <= s.length() - 1; i++) {
      int n = (i) % m;
      if (n < nRows) {
        line.get(n).add(s.charAt(i));
      } else {
        line.get(2 * (nRows - 1) - n).add(s.charAt(i));
      }
    }
    String result = "";
    for (LinkedList<Character> l : line) {
      for (Character c : l) {
        result += c.toString();
      }
    }
    return result;
  }
}
