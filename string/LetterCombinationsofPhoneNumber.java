package string;

import java.util.ArrayList;

public class LetterCombinationsofPhoneNumber {
  public ArrayList<String> letterCombinations(String digits) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    String[] dial = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    if (digits.length() == 0) {
      result.add("");        // This line is extremely important, we cannot get anyting if we return a null;
      return result;
    } else {
      ArrayList<String> follow = letterCombinations(digits.substring(1, digits.length()));
      String l = dial[digits.charAt(0) - '0'];
      for (int i = 0; i <= l.length() - 1; i++) {
        for (String j : follow) {
          String r = l.charAt(i) + j;
          result.add(r);
        }
      }
    }
    return result;
  }
}
