package com.dp;

public class _509 {
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public int fibOptimized(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public int dfs(int n) {
        if (n <= 1) return n;
        return dfs(n - 1) + dfs(n - 2);
    }
}