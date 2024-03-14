package com.greed;

import java.util.ArrayList;
import java.util.List;

public class _763 {

    /**
     * 遍历字符串 s，记录每个字符最后一次出现的索引位置。
     * 再次遍历字符串 s，用两个变量 left 和 right 记录当前片段的起始和结束索引。
     * 对于当前遍历的字符，更新 right 为当前字符最后一次出现的位置和 right 的较大值。
     * 这确保了当前片段包含了所有当前已遍历字符的出现。
     * 如果当前索引等于 right，说明找到了一个片段，其包含了所有必须得字符。
     * 记录这个片段的长度，然后更新 left 为 right+1，寻找下一个片段。
     */
    public List<Integer> partitionLabels(String s) {
        // 记录每个字符最后一次出现的位置
        int[] lastPosition = new int[26];
        for (int i = 0; i < s.length(); i++) lastPosition[s.charAt(i) - 'a'] = i;
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, lastPosition[s.charAt(i) - 'a']);
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}
