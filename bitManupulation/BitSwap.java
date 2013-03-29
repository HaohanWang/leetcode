package bitManupulation;

public class BitSwap {
  public static void main(String args[]) {
    int m = 25;
    System.out.println(Integer.toBinaryString(m));
    int n = new BitSwap().swapOddEvenBits(m);
    m = new BitSwap().swapBinary(m);
    System.out.println(Integer.toBinaryString(m));
    System.out.println(Integer.toBinaryString(n));
  }

  public int swapBinary(int m) {
    int i = 0;
    int n = 0;
    while (m != 0) {
      int r = m & 1;
      int l = (m >> 1) & 1;
      n = r << (i + 1) | l << i | n;
      m = m >> 2;
      i += 2;
    }
    return n;
  }

  public int swapOddEvenBits(int x) {
    return (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
  }
}
