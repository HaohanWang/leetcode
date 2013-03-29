package array;

public class PermutationSequence {
  public static void main(String args[]) {
    int n = 4;
    int k = 15;
    System.out.println(new PermutationSequence().getPermutation(n, k));
  }

  public String getPermutation(int n, int k) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (n==1){
      return "1";
    }
    int[] count = new int[n];
    boolean[] map = new boolean[n];
    String r = "";
    count[0] = 1;
    count[1] = 1;
    for (int i = 2; i <= n - 1; i++) {
      count[i] = count[i - 1] * (i);
    }
    for (int i = n - 1; i >= 0; i--) {
      int m = (k - 1) / count[i] + 1;
      k = k - (m-1) * count[i];
      m = searchReal(m, map);
      r += String.valueOf(m);
      map[m - 1] = true;
    }
    return r;
  }

  public int searchReal(int m, boolean[] map) {
    int count=m;
    for (int i=0;i<=map.length-1;i++){
      if (map[i]==false){
        count--;
        if (count==0)
          return (i+1);
      }
    }
    return m;
  }
}
