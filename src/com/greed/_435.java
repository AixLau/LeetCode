package com.greed;

import java.util.Arrays;
import java.util.Comparator;

public class _435 {
    /**
     * 将区间按照结束坐标升序
     * 遍历排序后的区间集合，比较当前区间的开始坐标和前一个区间的结束坐标：
     * 如果当区间的开始坐标小于前一个区间的结束坐标（发生重叠），则需要移除已区间
     * 如果不重叠，将当前区间的结束坐标更新为前一个区间的结束坐标。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((a -> a[1])));
        int ans = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] < end) ans++;
            else end = intervals[i][1];
        return ans;
    }

    /**
     * 将区间按照开始坐标升序
     * 遍历排序后的区间集合，对于每个区间：
     * 如果当前区间与前一个区间不重叠（即当前区间的开始坐标大于或等于记录的结束坐标），
     * 我们直接移动到下一个区间。
     * 如果当前区间与前一个区间重叠，需要移除一个区间：选择结束坐标较小的区间来保留
     * 这样可以为后续区间留下更多的空间。同时增加移除区间的计数。
     */
    public int eraseOver(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] < end) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            } else end = intervals[i][1];
        return ans;
    }
}
