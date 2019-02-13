package cn.zhangchg.leetcode.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author 张晨刚
 */
public class MergeInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        //intervals.add(new Interval(1, 2));
        //intervals.add(new Interval(3, 5));
        //intervals.add(new Interval(6, 7));
        //intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(12, 16));
        //Interval newInterval = new Interval(4, 8);
        intervals.add(new Interval(2, 3));
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));
        //intervals.add(new Interval(12, 16));
        List<Interval> insert = merge(intervals);
        for (Interval interval : insert) {
            System.err.println(interval.start + "," + interval.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return 0;
                }
                return o1.start > o2.start ? 1 : -1;
            }
        });
        List<Interval> tmpIntervals = new ArrayList<>();
        Interval tmpInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (tmpInterval.end < interval.start) {
                tmpIntervals.add(tmpInterval);
                if (tmpIntervals.size() == intervals.size()) {
                    break;
                }
                tmpInterval = interval;
                continue;
            } else if (interval.end < tmpInterval.start) {
                tmpIntervals.add(interval);
                continue;
            }
            if (interval.start < tmpInterval.start) {
                tmpInterval.start = interval.start;
            }
            if (tmpInterval.end < interval.end) {
                tmpInterval.end = interval.end;
            }
        }
        if (tmpInterval.end != 0) {
            tmpIntervals.add(tmpInterval);
        }
        return tmpIntervals;
    }

}
