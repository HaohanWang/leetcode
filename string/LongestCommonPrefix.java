package string;

public class LongestCommonPrefix {
  public static void main(String args[]){
    String[] strs = {"aa", "aa"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs)+"*");
  }
  public String longestCommonPrefix(String[] strs) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (strs.length == 0) {
      return "";
    }
    String r = "";
    boolean equal = true;
    for (int j = 0; j <= strs[0].length() - 1 && equal; j++) {
      equal = true;
      for (int i = 1; i <= strs.length - 1; i++) {
        if (strs[i].length() <= j || strs[i].charAt(j) != strs[i - 1].charAt(j)) {
          equal = false;
          break;
        }
      }
      if (equal) {
        r = r + strs[0].charAt(j);
      }
    }
    return r;
  }
}
