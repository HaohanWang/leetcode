package dynamicProgramming;

public class MaxSumofLine {
  public static void main(String args[]){
    int [] input = {3, 4,5,-6, -6, 4, 3, 5, -4, -3, -5, 3, 4, 5, 2, 8, 1, -7, 3, 8,10,-5};
    System.out.println(new MaxSumofLine().findMaxSum(input));
    
  }
  int findMaxSum(int [] a){
    int [] sum = new int [a.length];
    sum[0]=a[0];
    int max=0;
    for (int i=1;i<=a.length-1;i++){
      sum[i]=Math.max(a[i], a[i]+sum[i-1]);
      if (sum[i]>max){
        max=sum[i];
      }
    }
    return max;
  }
}
