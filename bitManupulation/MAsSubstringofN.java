package bitManupulation;

import java.util.BitSet;

public class MAsSubstringofN {
  public static void main(String args[]) {
    int m = Integer.parseInt("100011111111", 2);
    int n = Integer.parseInt("10111", 2);
    int i = 2;
    int j = 6;
    int r = new MAsSubstringofN().putMintoN(n, m, i, j);
    System.out.println(Integer.toBinaryString(r));
  }

  public int putMintoN(int m, int n, int i, int j) {
    int base = ~0;
    int left = base - ((1 << j) - 1);
    int right = ((1 << i) - 1);
    int mask = left | right;
    return (n & mask) | (m << i);
  }

  public int updateBits(int n, int m, int i, int j) {

    int max = ~0; /* All 1’s */
    // 1’s through position j, then 0’s
    int left = max - ((1 << j) - 1);
    System.out.println(left);
    // 1’s after position i
    int right = ((1 << i) - 1);
    System.out.println(right);
    // 1’s, with 0s between i and j
    int mask = left | right;
    System.out.println(mask);
    // Clear i through j, then put m in there
    return (n & mask) | (m << i);
  }

}
