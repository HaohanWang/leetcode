package array;

public class QuickSort {
  public static void main(String args[]){
    int[] array = {12,5,25,6,8,17,9,3,22,2,65,72,13};
    QuickSort qs = new QuickSort(array);
    qs.sort();
  }
  
  public QuickSort(int[] anArray) {
    a = anArray;
  }

  /**
   * Sorts the array managed by this sorter
   */
  public void sort() {
    sort(0, a.length - 1);
  }

  public void sort(int low, int high) {
    if (low >= high)
      return;
    int p = partition(low, high);
    print();
    sort(low, p);
    sort(p + 1, high);
  }

  private int partition(int low, int high) {
    // First element
    int pivot = a[low];

    // Middle element
    // int middle = (low + high) / 2;
    // int pivot = a[middle];

    int i = low - 1;
    int j = high + 1;
    while (i < j) {
      i++;
      while (a[i] < pivot)
        i++;
      j--;
      while (a[j] > pivot)
        j--;
      if (i < j)
        swap(i, j);
    }
    return j;
  }

  /**
   * Swaps two entries of the array.
   * 
   * @param i
   *          the first position to swap
   * @param j
   *          the second position to swap
   */
  private void swap(int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  private void print(){
    for (int i=0;i<=a.length-1;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }

  private int[] a;
}
