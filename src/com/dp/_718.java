package com.dp;

public class _718 {
    /**
     * dp[i][j] 表示以 nums1[i-1]和 nums2[j-1] 结尾的最长公共子数组的长度。
     * 这里使用 i-1 和 j-1 是因为 dp 数组的大小会被设置为（len(nums1)+1)*(len(num2)+1),
     * 以便能够处理空数组的情况，并让索引 nums1 和 nums2 对应上。
     * 状态转移方程：
     * 如果 nums1[i-1]==nums2[j-1]，那么 dp[i][j]=dp[i-1][j-1]+1。
     * 这表示当前元素相等，所以当前的最长公共子数组的长度是基于前一个状态的长度+1。
     * 如果 nums1[i-1]!=nums2[j-1]，那么dp[i][j]=0。因为子数组要求连续，一旦不匹配，长度重置为 0。
     * 初始化：
     * dp[0][j]和 dp[i][0]为 0，因为如果有一个数组是空的，则公共子数组的长度为 0。
     */
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
        return maxLen;
    }
}
