package cn.zhangchg.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author 张晨刚
 */
public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        //intervals.add(new Interval(1, 2));
        //intervals.add(new Interval(3, 5));
        //intervals.add(new Interval(6, 7));
        //intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(12, 16));
        //Interval newInterval = new Interval(4, 8);
        intervals.add(new Interval(3, 5));
        //intervals.add(new Interval(3, 5));
        intervals.add(new Interval(13, 15));
        //intervals.add(new Interval(9, 11));
        //intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(6, 6);
        List<Interval> insert = insert(intervals, newInterval);
        for (Interval interval : insert) {
            System.err.println(interval.start + "," + interval.end);
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> tmpIntervals = new ArrayList<>();
        Interval tmpInterval = new Interval();
        boolean isEnd = false;
        boolean isTmp = false;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                tmpIntervals.add(interval);
                if (tmpIntervals.size() == intervals.size()) {
                    tmpIntervals.add(newInterval);
                    break;
                }
                continue;
            } else if (interval.start > newInterval.end) {
                if (tmpIntervals.size() == 0 && tmpInterval.end == 0) {
                    tmpIntervals.add(newInterval);
                    tmpIntervals.addAll(intervals);
                    break;
                }
                if (!isTmp) {
                    if (tmpInterval.end != 0) {
                        tmpIntervals.add(tmpInterval);
                    } else {
                        tmpIntervals.add(newInterval);
                    }
                    isTmp = true;
                }
                tmpIntervals.add(interval);
                isEnd = true;
                continue;
            }
            if (tmpInterval.end == 0) {
                if (interval.start < newInterval.start) {
                    tmpInterval.start = interval.start;
                } else {
                    tmpInterval.start = newInterval.start;
                }
            }
            if (newInterval.end > interval.end) {
                tmpInterval.end = newInterval.end;
            } else {
                tmpInterval.end = interval.end;
            }
        }
        if (!isEnd && tmpInterval.end != 0) {
            tmpIntervals.add(tmpInterval);
        }
        return tmpIntervals;
    }

}
