package com.dp;

public class _309 {
    /**
     * 每一天维护三种状态：
     * 持有股票：在这一天结束时，持有一支股票。
     * 不持有股票，处于冷冻期：在这一天结束时，不持有股票，且因为在这一天卖出了股票，所以处于冷冻期。
     * 不持有股票，不处于冷冻期：在这一天结束时，不持有股票，且不处于冷冻期。
     * 对于每一天，都可以根据前一天的状态来更新这三个状态：
     * 持有股票：可能是前一天就持有股票，或今天买入了股票。
     * 冷冻期：只能是前一天卖出了股票。
     * 不持有股票：可能是前一天也不持有股票且不处于冷冻期，或前一天处于冷冻期。
     * 状态转移方程：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][2] - prices[i]) 保持持有或从不持有买入。
     * dp[i][1] = dp[i-1][0] + prices[i] 前一天持有，今天卖出
     * dp[i][2] = max(dp[i-1][2], dp[i-1][1]) 保持不持有或从冷冻期转入
     * 初始化：
     * 第 0 天持有股票 dp[0][0] = -prices[0]
     * 第 0 天不持有股票处于冷冻期：不可能，因为第 0 天不能通过买卖股票进入冷冻期 dp[0][1] =Integer.MIN_VALUE
     * 第 0 天不持有股票：dp[0][2] = 0
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    /**
     * 使用两个一维数组优化空间
     * buy[i]表示在第 i 天结束时，最后一次操作是买入的最大利润。
     * sell[i]表示在第 i 天结束时，最后一次操作是卖出的最大利润。
     * 由于卖出股票后的第二天是冷冻期，不能在冷冻期买入股票，意味着如果今天买入股票，昨天一定不能卖出股票。
     * 状态转移方程：
     * buy[i] = max(buy[i-1], sell[i-2] - prices[i])，表示对于今天的买入，可以选择保持昨天的买入状态，
     * 或在前天卖出后，今天买入（因为昨天是冷冻期）。
     * sell[i] = max(sell[i-1], buy[i-1] + prices[i])，表示对于今天的卖出，可以选择保持昨天的卖出状态，
     * 或昨天买入，今天卖出。
     * 初始化
     * buy[0]=-prince[0]，表示第一天买入股票。
     * sell[0]=0，表示第一天不能卖出股票。
     * 为了处理 buy[i-1] 在 i=1 时的情况，可以设置 sell[-1]=sell[1]=0。
     * 意味着在开始之前，没有任何股票可以卖，利润为 0。
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
