package integer;

public class ReverseBits {
  public static void main(String args[]) {
    for (int i = 0; i <= 100000; i++) {
      System.out.println(Integer.toBinaryString(i) + " " + i);
      int j = new ReverseBits().reverseBits(i);
      System.out.println(Integer.toBinaryString(j) + " " + j);
      System.out.println("---------------");
    }
  }

  public int reverseBits(int m) {
    String s = Integer.toBinaryString(m);
    int j = s.length() - 1;
    char[] c = s.toCharArray();
    int i = 0;
    while (i < j) {
      char temp = c[i];
      c[i++] = c[j];
      c[j--] = temp;
    }
    s = String.valueOf(c);
    return Integer.parseInt(s, 2);
  }

}
