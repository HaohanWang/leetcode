package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Go to see the solution in dynamicProgramming package
 * @deprecated
 * @author haohanwang
 *
 */

public class DistinctSubsequence {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String S = in.nextLine();
    String T = in.nextLine();
    System.out.println(new DistinctSubsequence().countDistinctSubsequence(S, T));
  }
  
  public int countDistinctSubsequence(String s, String t){
    LinkedList<LinkedList<Integer>> position = new LinkedList<LinkedList<Integer>>();
    ArrayList<Integer> index = new ArrayList<Integer>();
    for (int i=0;i<=t.length()-1;i++){
      LinkedList<Integer> a = new LinkedList<Integer>();
      position.add(a);
      index.add(0);
    }
    int tail=0;
    for (int i=0;i<=s.length()-1;i++){
      for (int j=0;j<=tail;j++){
        if (s.charAt(i)==t.charAt(j)){
          if (j==tail&&j<t.length()-1){
            tail++;
          }
          if (j==0){
            position.get(0).add(i);
            int temp = index.get(0);
            index.set(0, temp+1);
          }
          else{
            int addPos = position.get(j).size();
            if (position.get(j-1).size()<=addPos){
              position.get(j).add(i);
              int temp = index.get(j);
              index.set(j, temp+1);
            }
            else{
              if (position.get(j-1).get(addPos)<i){
                position.get(j).add(i);
                int temp = index.get(j);
                index.set(j, temp+1);
              }
            }
          }
        }
      }
    }
    for (int i=position.size()-2;i>=0;i--){
      int last = position.get(i+1).size()-1;
      int cur = position.get(i).size()-1;
      while (position.get(i).get(cur)>position.get(i+1).get(last)){
        position.get(i).remove(cur);
        cur--;
        index.set(i, cur);
      }
      if (position.get(i).get(cur)==position.get(i+1).get(last)){
        position.get(i+1).remove(last);
        last--;
        index.set(i+1, last);
      }
    }
    int result = 1;
    for (int i = 1;i<=position.size()-1;i++){
      result*=position.get(i).size();
    }
    return result;
  }
}
