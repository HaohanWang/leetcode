package string;

import java.util.Stack;

public class ValidParenthese {
  public boolean isValid(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    Stack<Character> t = new Stack<Character>();
    for (int i = 0; i <= s.length() - 1; i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        t.push(s.charAt(i));
      } else {
        if (t.isEmpty()) {
          return false;
        } else if (t.peek() + 1 == s.charAt(i) || t.peek() + 2 == s.charAt(i)) {
          t.pop();
        } else {
          return false;
        }
      }
    }
    return t.isEmpty();
  }
}
