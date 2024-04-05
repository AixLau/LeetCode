package com.dp;

import java.util.Arrays;

public class _300 {
    /**
     * 定义一个数组 dp，其中 dp[i] 表示以 nums[i]结尾的最长严格递增子序列长度。
     * 对于每一个 nums[i]，从 j=0 到 i-1 遍历 nums，如果 nums[j]<nums[i]，
     * 那么 nums[i]可以接在 nums[j] 结尾的递增子序后面形成一个新的递增子序列，
     * 因此有dp[i] = max(dp[i], dp[j] + 1);
     * 1.初始化一个长度与原数组相同的 dp 数组，每个元素的值为 1，因为最长递增子序列的最小长度为 1。
     * 2.双层 for 循环遍历数组，外层循环变量 i 从 1 开始到 nums.length-1，内循环变量 j 从 0 开始到 i-1。
     * 在内层循环中，如果 nums[j]<nums[i]，则更新 dp[i] = max(dp[i], dp[j] + 1);
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
