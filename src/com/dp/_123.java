package com.dp;

public class _123 {
    /**
     * dp[i][0]：表示在第 i 天结束时，第一次买入的最大利润。
     * dp[i][1]：表示在第 i 天结束时，第一次卖出的最大利润。
     * dp[i][2]：表示在第 i 天结束时，第二次买入的最大利润。
     * dp[i][2]：表示在第 i 天结束时，第二次卖出的最大利润。
     * 初始化：
     * 第一天第一次买入，则利润为-prices[0]
     * 第一天第二次买入，同样利润为-prices[0]
     * 状态转移：
     * dp[i][0]：是之前已经买入的最大利润，和当天买入的最大利润中的较大值。
     * dp[i][1]：是之前已经卖出的最大利润和当天卖出的最大利润中的较大者
     * dp[i][2]：是之前已经进行第二次买入的最大利润和用第一次卖出的利润减去今天的价格中的较大者。
     * dp[i][3]：是之前已经进行第二次卖出的最大利润和用第二次买入的利润加上今天的价格中的较大者。
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }

    /**
     * 始化状态：我们需要四种状态来跟踪每次交易的买入和卖出：
     * buy1：进行第一次买入后的最大利润。
     * sell1：进行第一次卖出后的最大利润。
     * buy2：进行第二次买入后的最大利润。
     * sell2：进行第二次卖出后的最大利润。
     * 状态转移：
     * buy1更新为max(buy1, -prices[i])：这意味着要么保持之前买入的状态（如果已经买入），要么在今天买入（第一次买入）
     * sell1更新为max(sell1, buy1 + prices[i])：这表示要么保持之前的卖出状态，要么就在今天卖出（在之前买入的基操上）。
     * buy2更新为max(buy2, sell1 - prices[i])：在第一次卖出之后，可以选择再次买入。
     * sell2更新为max(sell2, buy2 + prices[i])：在第二次买入后可能卖出的操作。
     */
    public int maxProfit2(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
