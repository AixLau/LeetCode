package com.dp;

public class _377 {
    public int combinationSum4(int[] nums, int target) {
        /**
         * 定义状态：dp[i]为总和 i 的元素组合的个数
         * 初始化：dp[0]=1，因为总和为 0 的情况下，只有一种组合，即不选任何数字。
         * 填充DP表：遍历 1 到 target 的每个可能的总和 i，对于每个 i，遍历数组 nums 中的每个数 num
         * 如果 i 大于等于 num，那么 dp[i]+=dp[i-num]。这表示，如果之前已经计算出总和为 i-num 的组合数，
         * 通过添加 i-num 的组合数，通过添加 num，我们可以得到一个新的总和为 i 的组合。
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums) if (i >= num) dp[i] += dp[i - num];
        return dp[target];
    }
}
