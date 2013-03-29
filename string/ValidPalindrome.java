package string;

import java.util.Scanner;

public class ValidPalindrome {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    System.out.println(new ValidPalindrome().isPalindrome(s));
  }
  
  
  boolean isPalindrome(String s) {
    int length = s.length() - 1;
    if (length <= 0) {
      return true;
    }
    int h = 0, t = length;
    while (h <= t) {
      char ch = s.charAt(h);
      char ct = s.charAt(t);
      if (JudgeIn(ch) == 2) {
        ch = (char) (ch - 'A' + 'a');
      }
      if (JudgeIn(ct) == 2) {
        ct = (char) (ch - 'A' + 'a');
      }
      if (JudgeIn(ch) == 1 && JudgeIn(ct) == 1) {
        if (ch == ct) {
          h++;
          t--;
        }
        if (ch != ct) {
          return false;
        }
      }
      if (JudgeIn(ch)==0){
        h++;
      }
      if (JudgeIn(ch)==0){
        t--;
      }
    }
    return true;
  }

  int JudgeIn(char c) {
    if (c >= 'a' && c <= 'z')
      return 1;
    if (c >= 'A' && c <= 'Z')
      return 2;
    return 0;
  }
}
