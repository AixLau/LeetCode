package com.dp;

public class _121 {

    /**
     * 显式地构建一个 dp 二维数组来跟踪每一天可能的两种状态：
     * dp[i][0]：表示第 i 天结束时持有股票的最大利润。
     * dp[i][1]：表示第 i 天结束时不持有股票的最大利润。
     * 初始化：
     * dp[0][0]=-prices[0]，表示在地 0 天买入股票的成本（负利润）。
     * dp[0][1]=0，表示第 0 天结束时不持有股票的利润（没有买入，因此没有利润）。
     * 状态转移：
     * 从第 1 天开始，第 0 天已经初始化了。
     * dp[i][0]，可以从两种状态转移而来：
     * 保持前一天持有的股票，即 dp[i-1][0]。
     * 或在第 i 天买入股票，这意味着成本为 -prices[i]（因为我们只允许一次买卖，
     * 所以这里没考虑 dp[i-1][1]-prices[i]，这对应多次交易情况）。
     * dp[i][1]，也可以从两种状态转移而来：
     * 保持前一天不持有股票的状态，即 dp[i-1][1]。
     * 或在第 i 天卖出股票，这样会产生利润 prices[i]加上前一天持有股票的利润 dp[i-1][0]。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }

    /**
     * 一次遍历法
     * 思想解析：
     * 我们想要找到最低价格的时候买入，然后在未来某天（价格最高的时候）卖出。
     * 关键点是我们只允许进行一次交易，所以我们必须在最低点买入后的最高点卖出。
     * 通过一次遍历数组来完成这个任务，遍历过程中记录两个值：
     * minPrice：到目前为止的最低价格（可以在这个价格买入）。
     * maxPrice：到目前为止可能的最大利润（当前价格减去记录的最低价格）。
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
            // 更新最小价格
            if (prices[i] < minPrice) minPrice = prices[i];
                // 更新最大利润
            else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        return maxProfit;
    }
}