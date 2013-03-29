package array;

import java.util.ArrayList;

import integer.Interval;

public class InsertInterval {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (intervals.size() == 0) {
      intervals.add(newInterval);
      return intervals;
    }
    int addIndex = intervals.size();
    boolean change = false;
    for (int i = intervals.size() - 1; i >= 0; i--) {
      Interval in = intervals.get(i);
      if (JudgeIn(in, newInterval)) {
        newInterval.start = Math.min(in.start, newInterval.start);
        newInterval.end = Math.max(in.end, newInterval.end);
        addIndex = i;
        change = true;
        intervals.remove(i);
      }
    }
    if (change)
      intervals.add(addIndex, newInterval);
    else {
      int i = 0;
      for (; i <= intervals.size() - 1; i++) {
        if (intervals.get(i).start > newInterval.start) {
          break;
        }
      }
      intervals.add(i, newInterval);
    }
    return intervals;
  }

  public boolean JudgeIn(Interval m, Interval n) {
    if (m.start > n.end || n.start > m.end) {
      return false;
    }
    return true;
  }
}
