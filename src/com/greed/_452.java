package com.greed;

import java.util.Arrays;
import java.util.Comparator;

public class _452 {
    /**
     * 首先按照气球的开始坐标对气球进行升序
     * 初始化需要射出的箭的数量为 1，因为至少需要一支箭来射穿至少一个气球。
     * 然后将当前箭的位置设置为第二气球的开始坐标。
     * 遍历排序后的气球数组，对于每个气球，检查它的开始坐标是否大于前一个气球结束的坐标，
     * 如果是，这意味着当前的箭无法射穿这个气球，引测我们需要射出一只新的箭。
     * 如果当前气球的开始坐标小于等于前一个气球的结束坐标，说明这支箭可以射穿当前气球，
     * 将当前气球的结束坐标设置为前一个气球的结束坐标，看下一个气球能否被这支箭射到。
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int arrows = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            int[] point = points[i];
            if (point[0] > prev[1]) arrows++;
            else point[1] = Math.min(prev[1], point[1]);
        }
        return arrows;
    }

    /**
     * 按照气球的结束坐标对气球进行排序。
     * 初始化需要射出的箭的数量为1，因为至少需要一箭来射穿至少一个气球。
     * 然后将当前箭的位置设置为第一个气球的结束坐标。
     * 遍历排序后的气球数组，对于每一个气球，我们检查它的开始坐标是否大于当前箭的位置。
     * 如果是，这意味着当前的箭无法射穿这个气球，因此我们需要射出一支新的箭，
     * 并更新当前箭的位置为这个新气球的结束坐标。
     * 如果当前气球的开始坐标不大于当前箭的位置，这意味着当前的箭可以射穿这个气球，
     * 我们不需要做任何操作。
     */
    public int findMinArrow(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int arrowPos = points[0][1];
        for (int i = 1; i < points.length; i++)
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        return arrows;
    }
}
