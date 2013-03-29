package bitManupulation;

public class BitToChange {
  public static void main(String args[]) {
    int m = 14;
    int n = 23;
    System.out.println(Integer.toBinaryString(m));
    System.out.println(Integer.toBinaryString(n));
    System.out.println(new BitToChange().countBitsToChange(m, n));
  }

  public int countBitsToChange(int m, int n) {
    int x = m ^ n;
    int count = 0;
    for (; x != 0; x = x >> 1) {
      count += x & 1;
    }
    return count;
  }
}
