package com.dp;

import java.util.Arrays;

public class _279 {
    /**
     * 定义状态：创建一个数组 dp，其中 dp[i] 表示组成总数 i 所需的最少数量的完全平方数。
     * 初始化：初始化 dp[0]=0，因为总数为 0 不需要任何完全平方数。
     * 其余的 dp[i] 初始化为一个较大值，表示最初假设所有总数都不能由完全平方数组成。
     * 状态转移：对于每个 i（从 1 到 n），遍历所有的完全平方数 square，更新 dp[i] 为
     * Math.min(dp[i], dp[i - square] + 1)，要组成总数 i，可以选择任何一个完全平方数 square，
     * 然后为剩下的 i-square 部分找到最少的完全平方数，再加上刚刚选择的这一个 square。
     * 返回结果：dp[n]即为组成总数 n 所需的最少数量的完全平方数。
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        return dp[n];
    }
}
