package integer;

public class Pow {

  public double pow(double x, int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    boolean pos = n > 0 ? true : false;
    n = Math.abs(n);
    if (n == 0) {
      // if (x!=0)
      return 1;
      // else{};
    }
    if (x == 0)
      return 0;

    if (n == 1 && pos)
      return x;
    if (n == 1 && !pos)
      return 1 / x;
    double pro = x;
    int i = 0;
    for (i = 2; i <= n; i = i * 2) {
      pro = pro * pro;
    }
    i = i / 2;
    for (int j = n - i; j >= 1; j--) {
      pro *= x;
    }
    if (pos) {
      return pro;
    } else {
      return 1 / pro;
    }
  }
}