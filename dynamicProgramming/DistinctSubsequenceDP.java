package dynamicProgramming;

public class DistinctSubsequenceDP {
  /**
   * pay attention to the strategy.
   * for each char in T, ie, char i, if there is a char in S, ie, char j equals to it,  
   * then we need to count the distinct subsequences numbers of string T.substr(0, i) in S.substr(0, j)
   * if char i+1 is not the same as char j+1, then the ds number of T.substr(0, i+1) in S(0, j+1) is the same as T(0, i+1) in S(0, j)
   * else ds number of T(0, i+1) in S(0, j+1)=ds number of T(0, i+1) in S(0, j)+ds number of T(0, i) in S(0, j)
   * The following code is counting backwards
   * If there is only one array, we need to pay attention to the sequences of calculating. 
   * @param S
   * @param T
   * @return
   * @author haohanwang
   */
  public int numDistinct(String S, String T) {
    // Start typing your Java solution below
    // DO NOT write main() function
    
    int [] result = new int[T.length()+1];
    result[T.length()]=1;
    for (int j=S.length()-1;j>=0;j--){
        for (int i=0;i<=T.length()-1;i++){
            if (S.charAt(j)==T.charAt(i)){
                result[i]+=result[i+1];
            }
        }
    }
    return result[0];
}
}
