package com.dp;

import java.util.Arrays;

public class _179 {
    /**
     * 将整数数组转换为字符数组
     * 使用自定义比较器对字符串数组进行排序。比较逻辑为是，对于两个字符串 a 和 b，
     * 如果 a+b>b+a，则 a 在 b 前面。
     * 将排序后的字符串数组拼接成一个字符串。
     * 如果最终结果的第一个字符串是 0，说明所有的数字都是 0，返回 0
     */
    public String largestNumber(int[] nums) {
        String[] asStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) asStr[i] = String.valueOf(nums[i]);
        Arrays.sort(asStr, (a, b) -> (b + a).compareTo(a + b));
        if (asStr[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for (String s : asStr) result.append(s);
        return result.toString();
    }
}
