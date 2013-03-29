package array;

import java.util.Stack;

public class MaximalRectangle {
  public static void main(String args[]) {
    String[] input = { "000011101", "001111101", "000111110" };
    char[][] matrix = new char[3][9];
    for (int i = 0; i <= input.length - 1; i++) {
      for (int j = 0; j <= input[0].length() - 1; j++) {
        matrix[i][j] = input[i].charAt(j);
      }
    }
    System.out.println(new MaximalRectangle().maximalRectangle(matrix));
  }

  public int maximalRectangle(char[][] matrix) {
    // Start typing your Java solution below
    // DO NOT write main() function

    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length, max = 0;
    int[] heights = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          heights[j]++;
        } else {
          heights[j] = 0;
        }
      }

      max = Math.max(max, maxHistoArea(heights));
    }

    return max;
  }

  public int maxHistoArea(int[] heights) {
    class Ele {
      int h;

      int i;

      public Ele(int h, int i) {
        this.h = h;
        this.i = i;
      }
    }

    Stack<Ele> st = new Stack<Ele>();
    int max = 0, i = 0;

    for (i = 0; i < heights.length; i++) {
      if (st.empty() || heights[i] > st.peek().h) {
        st.push(new Ele(heights[i], i));
      } else if (heights[i] < st.peek().h) { // ignore the equal case
        int prev = 0;
        while (!st.empty() && heights[i] < st.peek().h) {
          Ele e = st.pop();
          prev = e.i;
          max = Math.max(max, e.h * (i - e.i));
        }
        st.push(new Ele(heights[i], prev));
      }
    }

    while (!st.empty()) {
      Ele e = st.pop();
      max = Math.max(max, e.h * (i - e.i));
    }

    return max;
  }
}
