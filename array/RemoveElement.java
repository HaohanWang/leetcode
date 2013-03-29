package array;

public class RemoveElement {
  public static void main(String args[]){
    int [] A={2,4,4,4,0};
    int elem = 4;
    System.out.println(new RemoveElement().removeElement(A, elem));
  }
  public int removeElement(int[] A, int elem) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length == 0) {
      return 0;
    }
    int i = 0, j = A.length - 1;
    while (i < j) {
      while (j >= 0 && A[j] == elem) {
        j--;
      }
      if (A[i] == elem && j >= 0 && i< j) {
        A[i] = A[j];
        i++;
        j--;
      } else {
        i++;
      }
    }
    if (j < 0)
      return 0;
    if (A[j] == elem)
      return j;
    else
      return j + 1;
  }
}
