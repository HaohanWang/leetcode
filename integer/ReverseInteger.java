package integer;

public class ReverseInteger {
  /**
   * The only one thing we need to care about is that sometimes the reverse of 1000000003 could blow the stack. 
   * However, i do think there are implementations that can handle this since we need return an int. 
   * @param x
   * @return
   */
  public int reverse(int x) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int result = 0;
    boolean minus = false;
    if (x < 0) {
      x = Math.abs(x);
      minus = true;
    }
    while (x != 0) {
      int c = x % 10;
      x /= 10;
      result = result * 10 + c;
    }
    if (minus) {
      return 0 - result;
    }
    return result;
  }
}
