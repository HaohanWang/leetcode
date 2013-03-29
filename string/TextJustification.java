package string;

import java.util.ArrayList;

public class TextJustification {
  public static void main(String args[]) {
    String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
    int L = 16;
    ArrayList<String> r = new TextJustification().fullJustify(words, L);
    for (String s : r) {
      System.out.println(s);
    }
  }

  public ArrayList<String> fullJustify(String[] words, int L) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> r = new ArrayList<String>();
    if (words.length == 0) {
      return r;
    }
    int start = 0;
    int end = 0;
    int count = 0;
    for (int i = 0; i <= words.length - 1; i++) {
      if (addIn(count, words[i], L)) {
        start = Math.min(start, i);
        end = Math.max(end, i);
        count += words[i].length() + 1;
      } else {
        String line = justifyLine(words, start, end, count, L);
        r.add(line);
        start = words.length + 1;
        end = -1;
        count = 0;
        i--;
      }
    }
    if (end == -1) {
      r.add(words[words.length - 1]);
    } else {
      String line = justifyLastLine(words, start, end, L);
      r.add(line);
    }
    return r;
  }

  public boolean addIn(int count, String word, int L) {
    return count + word.length() <= L;
  }

  public String justifyLine(String[] words, int start, int end, int count, int L) {
    int space = L - count + (end + 1 - start);
    int w = end + 1 - start;
    String line = "";
    for (int i = start; i <= end; i++) {
      line += words[i];
      line += generateSpace(space, w, i - start);
    }
    return line;
  }

  public String generateSpace(int space, int w, int offset) {
    String s = "";
    if (w == 1) {
      for (; space >= 1; space--)
        s += " ";
      return s;
    }
    int bs = space / (w - 1);
    if (offset + 1 == w)
      return s;
    if (offset <= space % (w - 1) - 1)
      s += " ";
    for (; bs >= 1; bs--)
      s += " ";
    return s;
  }

  public String justifyLastLine(String[] words, int start, int end, int L) {
    String line = "";
    for (int i = start; i <= end; i++) {
      line += words[i];
      line += i == end ? "" : " ";
    }
    for (int i = L - line.length(); i >= 1; i--) {
      line += " ";
    }
    return line;
  }
}
