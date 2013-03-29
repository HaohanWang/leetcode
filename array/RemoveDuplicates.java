package array;

public class RemoveDuplicates {
  public static void main(String args[]) {
    int[] A = { 1, 1, 1, 2, 3 };
    System.out.println(new RemoveDuplicates().removeDuplicatesII(A));
  }

  public int removeDuplicates(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int diff = 0;
    for (int i = 1; i <= A.length - 1; i++) {
      if (A[i] != A[i - diff - 1]) {
        A[i - diff] = A[i];
      } else {
        diff += 1;
        A[i - diff] = A[i];
      }
    }
    return A.length - diff;
  }

  public int removeDuplicatesII(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length <= 2)
      return A.length;
    int count = 0;
    int j = 0;
    for (int i = 1; i <= A.length - 1; i++) {
      if (A[i] == A[i - 1]) {
        count++;
        if (count < 2) {
          A[j + 1] = A[i];
          j++;
        }
      } else {
        count = 0;
        A[j + 1] = A[i];
        j++;
      }
    }
    return j + 1;
  }
}
