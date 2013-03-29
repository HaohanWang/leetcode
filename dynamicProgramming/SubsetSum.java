package dynamicProgramming;

import input.RandomNumber;

public class SubsetSum {
  public boolean findSum(int[] set, int length, int K) {
    int[] result = new int[K + 1];
    if (set[0] == K) {
      return true;
    }
    result[set[0]] = 1;
    for (int i = 1; i <= length - 1; i++) {
      for (int j = 0; j <= K; j++) {
        if (result[j] != 0) {
          if (j + set[i] <= K) {
            result[j + set[i]] += result[j];
          }
          if (j == K) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String args[]) {
    int K = 899;
    int length = 20;
    int[] random = new RandomNumber().generateRandomNumber(10, 100);
    for (int i = 0; i <= length - 1; i++) {
      System.out.print(random[i] + " ");
    }
    System.out.println();
    System.out.println(new SubsetSum().findSum(random, length, K));
  }
}
