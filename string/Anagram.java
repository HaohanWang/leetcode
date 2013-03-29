package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
  public static void main(String args[]) {
    String[] strs = { "ape", "pea", "tax" };
    System.out.println(new Anagram().anagrams(strs));
    System.out.println("end");
  }
/**
 * This is a useful fuction to solve the problem of unknown length of strings.
 * @param word
 * @return
 */
  public String sortWord(String word) {
    char[] charArr = word.toCharArray();
    Arrays.sort(charArr);
    return new String(charArr);
  }

  public ArrayList<String> anagrams(String[] strs) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    char[][] chars = new char[strs.length][1000];
    boolean[] putin = new boolean[strs.length];
    for (int i = 0; i <= strs.length - 1; i++) {
      chars[i] = strs[i].toCharArray();
      Arrays.sort(chars[i]);
    }
    HashMap<String, Integer> anagram = new HashMap<String, Integer>();
    for (int i = 0; i <= strs.length - 1; i++) {
      if (anagram.containsKey(String.valueOf(chars[i]))) {
        int m = anagram.get(String.valueOf(chars[i]));
        if (putin[m] == false) {
          result.add(strs[m]);
          putin[m] = true;
        }
        result.add(strs[i]);
        putin[i] = true;
      } else {
        anagram.put(String.valueOf(chars[i]), i);
      }
    }
    return result;
  }
}
