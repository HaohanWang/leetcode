package integer;

public class DivideTwoIntegers {
  public static void main(String args[]) {
    int dividend = 125;
    int divisor = 7;
    System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
  }

  /**
   * Very brilliant implementation first check how many b can be minused from a, with exponentialy
   * increase, then need to check if the rest of a-b can still be minus like exponentially
   * 
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {
    // Start typing your Java solution below
    // DO NOT write main() function

    int a = Math.abs(dividend);
    int b = Math.abs(divisor);

    // b maybe Integer.MIN_VALUE

    boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
    if (divisor == 0) {

      return Integer.MAX_VALUE;
    }
    if (divisor == Integer.MIN_VALUE) {
      if (dividend == Integer.MIN_VALUE) {
        return 1;
      } else {
        return 0;
      }
    }
    if (dividend == Integer.MIN_VALUE) {
      if (neg) {
        return -1 + divide(dividend + b, b);
      } else {
        return 1 - divide(dividend + b, b);
      }
    }

    int product = b, result = 0;
    while (a >= b) {
      int q = 1;
      while (a - product >= product) {
        q = q << 1;
        product = product << 1;
      }
      a = a - product;
      product = b;
      result += q;
    }

    if (!neg) {
      return result;
    } else {
      return -result;
    }
  }
}
