package integer;

public class PerfectNumber {
  public static void main(String args[]) {
    int n = 30;
    for (int i = 0; i <= n; i++) {
      System.out.println(i + " " + new PerfectNumber().isPerfectNumber(i));
    }
  }

  public boolean isPerfectNumber(int n) {
    int sum = 0;
    for (int i = 1; i <= n - 1; i++) {
      if (n%i==0) {
        sum += i;
      }
    }
    return sum == n;
  }

  public boolean isPrime(int n) {
    if (n <= 2)
      return true;
    for (int i = 2; i <= n - 1; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}
