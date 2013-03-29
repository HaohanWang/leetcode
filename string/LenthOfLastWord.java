package string;

public class LenthOfLastWord {
  public static void main(String args[]) {
    String s = "a         ";
    System.out.println(new LenthOfLastWord().lengthOfLastWord(s));
  }

  public int lengthOfLastWord(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() == 0)
      return 0;
    int count = 0;
    int start = s.length() - 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ')
        start = i;
      else {
        start = i;
        break;
      }
    }
    for (int i = start; i >= 0; i--) {
      if (s.charAt(i) != ' ')
        count++;
      else
        break;
    }
    return count;
  }
}
