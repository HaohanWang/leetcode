package integer;

public class Sqrt {
  public static void main(String args[]) {
    int n = 5;
    System.out.println((int) Math.sqrt(n));
  }
/**
 * Other's solution, good job. 
 * This is actually not very difficult. 
 * @param x
 * @return
 */
  public int sqrt(int x) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (x == 0) {
      return 0;
    }

    int s = 2;
    int prev = 1;
    while (!(s <= x / s && (s + 1 > x / (s + 1)))) {
      if (s < x / s) {
        prev = s;
        s = s * s;
      } else {
        s = prev + (s - prev) / 2;
      }
    }
    return s;
  }
}
