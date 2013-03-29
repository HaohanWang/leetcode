package string;

public class AddBinary {
  public static void main(String args[]) {
    String a = "100";
    String b = "110010";
    System.out.println(new AddBinary().addBinary(a, b));
    System.out.println("end");
  }
/**
 * if the char array starts with null, though it has following values, it cannot be turned into Strings
 * @param a
 * @param b
 * @return
 */
  public String addBinary(String a, String b) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (a.equals("") || a.equals("0"))
      return b;
    if (b.equals("") || b.equals("0"))
      return a;
    char[] m = a.toCharArray();
    char[] n = b.toCharArray();
    int carry = 0;
    char[] r = new char[Math.max(a.length(), b.length()) + 1];
    int i = m.length - 1;
    int j = n.length - 1;
    while (i >= 0 && j >= 0) {
      int sum = (m[i] - '0') + (n[j] - '0') + carry;
      carry = sum / 2;
      sum = sum % 2;
      r[Math.max(i, j) + 1] = (char) (sum + '0');
      i--;
      j--;
    }
    if (i >= 0) {
      while (i >= 0) {
        int sum = (m[i] - '0') + carry;
        carry = sum / 2;
        sum = sum % 2;
        r[i + 1] = (char) (sum + '0');
        i--;
      }
    }
    if (j >= 0) {
      while (j >= 0) {
        int sum = (n[j] - '0') + carry;
        carry = sum / 2;
        sum = sum % 2;
        r[j + 1] = (char) (sum + '0');
        j--;
      }
    }
    // if (carry != 0)
    r[0] = (char) (carry + '0');
    String result = String.valueOf(r);
    int index = 0;
    if (result.charAt(0) == '0')
      index = 1;
    return result.substring(index, result.length());
  }
}
