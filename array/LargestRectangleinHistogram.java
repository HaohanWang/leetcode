package array;

import java.util.Stack;

public class LargestRectangleinHistogram {
  public static void main(String args[]) {
    int[] height = { 0, 1, 2, 3, 4, 5, 6, 1, 2 };
    System.out.println(new LargestRectangleinHistogram().largestRectangleArea(height));
  }

  public int largestRectangleArea(int[] height) {
    // Start typing your Java solution below
    // DO NOT write main() function

    // for every i, height[0...i] is a subproblem
    int i = 0, max = 0;
    Stack<Ele> st = new Stack<Ele>();
    while (i < height.length) {
      if (st.empty() || height[i] > st.peek().height) {
        st.push(new Ele(height[i], i));
      } else if (st.peek().height > height[i]) { // need to ignore the case where st.peek().height
                                                 // == height[i]
        int prev = 0;
        while (!st.empty() && st.peek().height > height[i]) {
          Ele e = st.pop();
          prev = e.index;
          max = Math.max(max, e.height * (i - e.index));
        }
        st.push(new Ele(height[i], prev));
      }
      i++;
    }

    // stack may contain a series of ascending heights
    while (!st.empty()) {
      Ele e = st.pop();
      max = Math.max(max, e.height * (i - e.index));
    }

    return max;
  }

  private class Ele {
    int height;

    int index;

    public Ele(int h, int i) {
      this.height = h;
      this.index = i;
    }
  }
}
