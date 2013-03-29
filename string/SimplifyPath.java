package string;

public class SimplifyPath {
  public static void main(String args[]) {
    String path = "/home/../../..";
    System.out.println(new SimplifyPath().simplifyPath(path));
  }

  public String simplifyPath(String path) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (path.equals("/"))
      return path;
    if (path.equals("/../"))
      return "/";
    String[] p = path.split("/");
    String r = "";
    for (int i = 0; i <= p.length - 1; i++) {
      if (!p[i].equals("")) {
        if (!p[i].equals(".")) {
          if (p[i].equals("..")) {
            r = removeLast(r);
          } else {
            r += "/";
            r += p[i];
          }
        }
      }
    }
    if (r.length() == 0) {
      r = "/";
    }
    return r;
  }

  public String removeLast(String r) {
    if (r.length() == 0) {
      return "";
    }
    int i = 0;
    for (i = r.length() - 1; i >= 0; i--) {
      if (r.charAt(i) == '/')
        break;
    }
    if (i == 0)
      return "";
    return r.substring(0, i);
  }
}
