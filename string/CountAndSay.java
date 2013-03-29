package string;

public class CountAndSay {
  public static void main(String args[]) {
    int n = 2;
    System.out.println(new CountAndSay().countAndSay(n));
  }

  public String countAndSay(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    String r = "";
    if (n == 0)
      return r;
    r = "1";
    for (int i = 1; i <= n - 1; i++) {
      r = countAndSay(r);
    }
    return r;
  }

  public String countAndSay(String n) {
    String r = "";
    for (int i = 0; i <= n.length() - 1; i++) {
      int m = countSameChar(i, n);
      r += String.valueOf(m) + String.valueOf(n.charAt(i));
      i += m - 1;
    }
    return r;
  }

  public int countSameChar(int m, String n) {
    if (m == n.length() - 1) {
      return 1;
    }
    int c = 1;
    for (int i = m + 1; i <= n.length() - 1; i++) {
      if (n.charAt(i) == n.charAt(i - 1)) {
        c++;
      } else
        break;
    }
    return c;
  }
}
