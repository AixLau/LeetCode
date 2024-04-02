package com.dp;

public class _122 {
    /**
     * dp[i][0]：持有股票最大利润。
     * dp[i][1]：不持有股票的最大利润。
     * 初始化：
     * dp[0][0] = -prices[0]，第 0 天就买入股票，利润就是负的。
     * dp[0][1] = 0，第 0 天没有买股票，利润是 0。
     * 状态转移：
     * dp[i][0]：
     * 前一天就持有股票，即 dp[i-1][0]，
     * 前一天没有持有股票，但今天买了，即 dp[i-1][1]-prices[i]。
     * dp[i][1]：
     * 前一天就没有股票，即 dp[i-1][1]，
     * 前一天持有股票，但今天卖了，即 dp[i-1][0]+prices[i]。
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
