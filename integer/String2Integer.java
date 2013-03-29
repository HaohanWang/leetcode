package integer;

public class String2Integer {
  public int atoi(String str) {
    // Start typing your Java solution below
    // DO NOT write main() function
    boolean neg = false;
    long result = 0;
    if (str.length() == 0)
      return (int) result;
    int start = 0;
    for (int i = 0; i <= str.length() - 1; i++) {
      if (str.charAt(i) != ' ') {
        start = i;
        break;
      }
      start = i;
    }
    if (str.charAt(start) == '-') {
      neg = true;
    } else if (str.charAt(start) == '+') {
      neg = false;
    } else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') {
      start--;
    } else {
      return 0;
    }
    for (int i = start + 1; i <= str.length() - 1; i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        result = result * 10 + str.charAt(i) - '0';
        if (result > Integer.MAX_VALUE) {
          return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
      } else
        break;
    }
    return neg ? -(int) result : (int) result;
  }
}
