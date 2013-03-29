package string;

import java.util.HashMap;
import java.util.Hashtable;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String args[]){
    String s ="abcabcde";
    System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
  }
  
  /*
   * A sligthly better implementation
   * 
  int lengthOfLongestSubstring(string s) {
  int n = s.length();
  int i = 0, j = 0;
  int maxLen = 0;
  bool exist[256] = { false };
  while (j < n) {
    if (exist[s[j]]) {
      maxLen = max(maxLen, j-i);
      while (s[i] != s[j]) {
        exist[s[i]] = false;
        i++;
      }
      i++;
      j++;
    } else {
      exist[s[j]] = true;
      j++;
    }
  }
  maxLen = max(maxLen, n-i);
  return maxLen;
}
   */
  
  public int lengthOfLongestSubstring(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() == 0) {
      return 0;
    }
    int[] index = new int[s.length()];
    int max = 0;
    HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    index[0] = 0;
    max = 1;
    hash.put(s.charAt(0), 0);
    for (int i = 1; i <= s.length() - 1; i++) {
      if (!hash.containsKey(s.charAt(i))) {
        hash.put(s.charAt(i), i);
        index[i] = index[i - 1];
        max = Math.max(max, i - index[i] + 1);
      } else {
        index[i] = hash.get(s.charAt(i)) + 1;
        for (int j=index[i];j<i;j++){
            index[i]=Math.max(index[j], index[i]);
        }
        max = Math.max(max, i - index[i] + 1);
        hash.remove(s.charAt(i));
        hash.put(s.charAt(i), i);
      }
    }
    return max;
  }
}
