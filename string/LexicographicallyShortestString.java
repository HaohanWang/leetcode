package string;

import java.util.Arrays;
import java.util.Comparator;

public class LexicographicallyShortestString {
  public static void main(String args[]) {
    String[] m = { "jibw", "ji", "jp", "bw", "jibw" };
    System.out
            .println(new LexicographicallyShortestString().findLexicographicallyShortestString(m));
  }

  public String findLexicographicallyShortestString(String[] m) {
    String r = "";
    Arrays.sort(m, new StringComparator());
    for (int i = 0; i <= m.length - 1; i++) {
      r += m[i];
    }
    return r;
  }

  class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      String s1 = o1 + o2;
      String s2 = o2 + o1;
      return s1.compareTo(s2);
    }

  }
}
