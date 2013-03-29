package array;

import integer.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * This is important, we need to get familiar with how to use comparator
 * @author haohanwang
 *
 */
public class MergeIntervals {
  public static void main(String args[]) {
    Interval a = new Interval(1, 4);
    Interval b = new Interval(0, 4);
    ArrayList<Interval> ins = new ArrayList<Interval>();
    ins.add(a);
    ins.add(b);
    ArrayList<Interval> r = new MergeIntervals().merge(ins);
    for (Interval m : r) {
      System.out.print(m.start + " " + m.end + "\t");
    }
  }

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (intervals.size() <= 1) {
      return intervals;
    }
    ArrayList<Interval> result = new ArrayList<Interval>();
    Collections.sort(intervals, IntervalComparator);
    // result.add(intervals.get(0));
    for (Interval m : intervals) {
      boolean putin = false;
      for (Interval n : result) {
        if (JudgeIn(m, n)) {
          n.start = Math.min(m.start, n.start);
          n.end = Math.max(m.end, n.end);
          putin = true;
          break;
        }
      }
      if (!putin) {
        result.add(m);
      }
    }
    return result;
  }

  public boolean JudgeIn(Interval m, Interval n) {
    if (m.start > n.end || n.start > m.end) {
      return false;
    }
    return true;
  }

  static final Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
    @Override
    public int compare(Interval o1, Interval o2) {
      // TODO Auto-generated method stub
      if (o1.start != o2.start) {
        return o1.start - o2.start;
      } else {
        return o1.end - o2.end;
      }
    }

  };
}
