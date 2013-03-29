package integer;

public class PalindromeNumber {
  /*
   * This is a nice recursive solution:
  bool isPalindrome(int x, int &y) {
  if (x < 0) return false;
  if (x == 0) return true;
  if (isPalindrome(x/10, y) && (x%10 == y%10)) {
    y /= 10;
    return true;
  } else {
    return false;
  }
}
bool isPalindrome(int x) {
  return isPalindrome(x, x);
}
   */
  
  public static void main(String args[]){
    int x = 1104114011;
    System.out.println(new PalindromeNumber().isPalindrome(x));
  }
  public boolean isPalindrome(int x) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (x < 0)
      return false;
    long i = 0;
    for (i = 1; i< x; i = i * 10);
    i=i/10;
    int j = 0;
    for (; j < i; i = i / 100) {
      j = 10;
      if (x / i != x % j) {
        return false;
      } else {
        x = x / (int) i;
        x = x / j;
      }
    }
    return true;
  }
}
