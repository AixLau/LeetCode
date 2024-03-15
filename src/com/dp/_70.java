package com.dp;

public class _70 {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public int climbOptimize(int n) {
        if (n < 2) return n;
        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
