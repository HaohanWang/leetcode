package string;

public class ScrambleString {
  public static void main(String args[]) {
    String s1 = "abc";
    String s2 = "bca";
    String t = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(t.substring(0, 10));
    System.out.println(t.substring(10));
    System.out.print(new ScrambleString().isScramble(s1, s2));
  }

  public boolean isScramble(String s1, String s2) {

    int n = s1.length();
    if (n == 1) {
      return s1.equals(s2);
    }
    for (int i = 1; i <= s2.length() / 2; i++) {
      String x1 = s1.substring(0, i), y1 = s1.substring(n - i), x2 = s2.substring(0, i), y2 = s2
              .substring(n - i);
      String a1 = s1.substring(i), b1 = s1.substring(0, n - i), a2 = s2.substring(i), b2 = s2
              .substring(0, n - i);

      boolean r1 = isScramble(x1, x2) && isScramble(a1, a2);
      if (r1)
        return true;
      boolean r2 = isScramble(x1, y2) && isScramble(a1, b2);
      if (r2)
        return true;
      boolean r3 = isScramble(y1, x2) && isScramble(b1, a2);
      if (r3)
        return true;
      boolean r4 = isScramble(y1, y2) && isScramble(b1, b2);
      if (r4)
        return true;
    }

    return false;
  }
}
