package dynamicProgramming;

import java.util.LinkedList;

public class UniqueBinarySearchTree {
  public static void main(String args[]){
    int n=15;
    System.out.println(new UniqueBinarySearchTree().numTrees(n));
  }
  public int numTrees(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (n<=1)
        return n;
    LinkedList<Integer> result = new LinkedList<Integer>();
    result.add(1);
    result.add(1);
    int temp=0;
    for (int i=2;i<=n;i++){
        temp=0;
        for (int j=1;j<=i;j++){
            temp+=result.get(j-1)*result.get(i-j);
        }
        result.add(temp);
    }
    return temp;
}
}
