package array;
/**
 * @deprecated
 * @author haohanwang
 *
 */
public class DistanceMaximizing {
  public static void main(String args[]){
    //int [] a = {1, 2, 2, 3, 3, 3, 4, 5};
    int [] a = {4, 3, 5, 2, 1, 3, 2, 2};
    System.out.println(new DistanceMaximizing().getMaximumDistance(a));
  }
  public int getMaximumDistance(int[] a) {
    int i = 0, j = 0;
    int r = 0;
    while (i <= a.length - 1) {
      if (a[i] < a[j]) {
        while (i<=a.length-1&&a[i] < a[j]) {
          i++;
        }
        while (j < i) {
          r = Math.max(r, i - j);
          j++;
        }
        i++;
      }
      else{
        r=Math.max(r, i-j);
        i++;
      }
    }
    return r;
  }
}
