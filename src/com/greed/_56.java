package com.greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class _56 {
    /**
     * 按照区间的起始位置对区间进行排序。确保在合并区间时，可以按照顺序处理。
     * 遍历区间数组，逐个检查每个区间是否与前一个区间重叠。
     * 如果当前区间与前一个区间重叠，将它合并为一个新区间（起始位置取两者中较小值，结束位置取两者中较大值）。
     * 如果不重叠，就直接将当前区间添加到结果列表中。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, (Comparator.comparingInt(a -> a[0])));
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals)
            // 如果结果列表为空，或当前区间不与前一个区间重叠，直接添加
            if (list.isEmpty() || list.getLast()[1] < interval[0]) list.add(interval);
                // 否则，合并当前区间和前一个区间
            else list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
        return list.toArray(new int[list.size()][]);
    }
}
