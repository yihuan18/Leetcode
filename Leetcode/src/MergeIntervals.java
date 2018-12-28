/*
Leetcode Q56 : 合并区间
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MergeIntervals {
    private Solution solution = new Solution();
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public class Solution{
        private class IntervalComparator implements Comparator<Interval>{
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.start-o2.start);
            }
        }

        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> ret = new ArrayList<>();
            intervals.sort(new IntervalComparator());
            for(Interval original : intervals){
                if(ret.size() > 0) {
                    Interval last = ret.get(ret.size() - 1);
                    if (original.start <= last.end)
                        last.end = Math.max(original.end,last.end);
                    else ret.add(new Interval(original.start,original.end));
                }
                else ret.add(new Interval(original.start,original.end));
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(4,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,9));
        intervals.add(new Interval(1,10));
        List<Interval> ret;
        ret = mergeIntervals.solution.merge(intervals);
        System.out.println(ret);

    }

}
