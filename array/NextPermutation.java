package array;

public class NextPermutation {
  public static void main(String args[]) {
    int[] num = { 1, 2, 3 };
    new NextPermutation().nextPermutation(num);
    for (int i : num) {
      System.out.print(i + " ");
    }
  }

  public void nextPermutation(int[] num) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (num.length > 1) {
      boolean max = true;
      for (int i = num.length - 1; i >= 1; i--) {
        if (num[i] > num[i - 1]) {
          max = false;
          int m = Integer.MAX_VALUE;
          int n = 0;
          for (int j = i; j <= num.length - 1; j++) {
            if (num[j] > num[i - 1] && num[j] < m) {
              m = num[j];
              n = j;
            }
          }
          int temp = num[n];
          num[n] = num[i - 1];
          num[i - 1] = temp;
          for (int j = i; j <= num.length - 1; j++) {
            for (int k = j + 1; k <= num.length - 1; k++) {
              if (num[j] > num[k]) {
                temp = num[j];
                num[j] = num[k];
                num[k] = temp;
              }
            }
          }
          break;
        }
      }
      if (max) {
        int i = 0, j = num.length - 1;
        while (i < j) {
          int temp = num[i];
          num[i++] = num[j];
          num[j--] = temp;
        }
      }
    }
  }
}
