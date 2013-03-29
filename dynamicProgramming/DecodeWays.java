package dynamicProgramming;

public class DecodeWays {
  public static void main(String args[]) {
    String s = "3119954855372556539644885655528885611447932724388523761611845475559682953295861537549737529449659194";
    System.out.println(new DecodeWays().numDecodings(s));
  }

  public int numDecodings(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() == 0)
      return 0;
    int[] n = new int[s.length() + 2];
    n[s.length()]=1;
    n[s.length()+1]=1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        n[i] = 0;
      } else {
        n[i] = n[i + 1];
      }
      if (i + 2 <= s.length()) {
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26&&Integer.parseInt(s.substring(i, i + 2))>=10) {
          n[i] += n[i+2];
        }
      }
    }
    return n[0];
  }
}
