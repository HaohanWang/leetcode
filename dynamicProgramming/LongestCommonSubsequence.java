package dynamicProgramming;

public class LongestCommonSubsequence {
  public int findLongestCommonSubsequence(String s, String t){
    int [][] l = new int [s.length()][t.length()];
    if (s.charAt(s.length()-1)==t.charAt(t.length()-1))
      l[s.length()-1][t.length()-1]=1;
    for (int i=s.length()-2;i>=0;i--){
      for (int j=t.length()-2;j>=0;j--){
        if (s.charAt(i)==t.charAt(j)){
          l[i][j]=l[i+1][j+1]+1;
        }
        else{
          l[i][j]=Math.max(l[i][j+1], l[i+1][j]);
        }
      }
    }
    return l[0][0];
  }
  
  public static void main(String args[]){
    String s = "abcdefghijklmnopqrstuvwxyz";
    String t = "bdfghilmppppppptuvwxyz";
    System.out.println(new LongestCommonSubsequence().findLongestCommonSubsequence(s, t));
  }
}
