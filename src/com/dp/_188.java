package com.dp;

public class _188 {
    /**
     * 动态规划数组定义
     * dp[i][j]表示在第 i 天结束时，进行了 j 次操作（买入、卖出各算一次操作）后能得到的最大利润。
     * 初始化：
     * 在第 0 天，对所有买入的状态(j为奇数时）进行初始化，设定为 -prices[0]。
     * 表示如果在0甜进行买入操作，那么成本就是第0天的股票价格。
     * 对于卖出状态（j为偶数，除了j=0，它代表未进行任何操作），初始化保持为0，没有进行任何买卖操作利润为0。
     * 状态转移：
     * dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i])：
     * 表示在第 i 天，如果选择进行一次买入操作（j+1 为奇数，代表买入）那么最大利润要么是保持昨天买入状态不变，
     * 要么是昨天处于卖出状态，然后今天买入。
     * dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i])：
     * 表示在第 i 天，如果选择进行一次卖出操作（j+2 为偶数，代表卖出），那么最大的利润要么保持昨天卖出的状态不变，
     * 要么是昨天处于买入的状态，然后今天卖出。
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) dp[0][i] = -prices[0];
        for (int i = 1; i < prices.length; i++)
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        return dp[prices.length - 1][2 * k];
    }

    /**
     * 定义 dp[i][j]为在第 j 天，最多进行 i 次交易能获得的最大利润。
     * maxDiff：帮助我们追踪到目前为止“最便宜的买入成本”。这个成本“不仅仅是股票价格的负值，
     * 还包括了之前交易所得的利润。换句话说 maxDiff 告诉我们，如果今天卖出股票，能从之前的购买中获得的最大利润是多少。
     * 初始化：
     * 对于 i=0，所有的 dp[0][j]=0，因为没有进行交易，所以不会有利润。
     * 对于 j=0，所有的 dp[i][0]=0，因为没有股票价格，所以不会有利润。
     * 状态转移：
     * 不在第 j 天卖出股票：此时的最大利润与前一天相同，即 dp[i][j-1]。
     * 在第 j 天卖出股票：此时的最大利润是 prices[i] + maxDiff.
     * 更新 maxDiff 为max(maxDiff, dp[i-1][j] - prices[j])。
     * 表示到目前为止，可以通过在 j 天之前的某一天买入的股票来获得最大利润。
     * dp[i-1][j] - prices[j]的意思是，在第 j 天买入股票之前已经完成 i-1 次交易的最大利润
     * 与在第 j 天买入股票所需的成本差值。这个差值反映了在第 j天买入股票后，从前面 i-1 次交易中
     * 累积的利润减去买入成本后，还能剩下多少利润。
     * （这相当于我们之前有一笔利润，现在我们要用这笔利润去买入股票，所以需要减去股票价格）。
     * <p>
     * 优化解决方案关键在于跟踪在第 j 天之前的 i-1 次交易的最大利润和第 j 天价格的最大差额。
     * 无需对每一天的所有前一天进行嵌套循环。
     * dp[i][j]追踪到第 j 天为止，最多进行 i 次交易能获得最大利润。
     * maxDiff 帮助计算在第 j 天之前进行第 i 次交易买入的最有利益。
     * 返回值 dp[k][n-1]给出了在最多 k 次交易限制下，到最后一天能够实现最大利润。
     */
    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k == 0) return 0;
        int n = prices.length;
        if (k >= n / 2) {
            // 如果 k 大于 n/2，可以进行无限次交易
            int maxProfit = 0;
            for (int i = 1; i < n; i++)
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            return maxProfit;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = i; j < n; j++) {
                // 在第 j 天不卖股票或卖出股票
                dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                // 更新最大差值，以便下一天的计算
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    /**
     * dp[i][j]表示在第i天结束时，最多完成j/2（因为买卖各算半次，所以总交易次数为j除以2）笔交易能获得的最大利润。
     * 由于每次交易包括买入和卖出两个动作，我们将j分为偶数和奇数两种情况：
     * 奇数j表示买入操作后的状态。
     * 偶数j表示卖出操作后的状态。
     * 初始化：
     * 在第0天，我们只能进行买入操作（假设交易次数为0开始，即j=1表示第一次买入），
     * 因此所有买入状态的初始值为-prices[0]，而所有卖出状态的初始值为0（未进行任何操作的利润为0）。
     * 状态转移：
     * 买入操作 j 为奇数：可以选择不买入，保持与昨天买入后的状态不变，或从上一个卖出的状态转换而来（买入股票），取决于哪个利润更大。
     * 卖出操作 j 为偶数：可以选择不卖出，保持与昨天卖出后的状态不变，或从上一个买入的状态转换而来（卖出股票），取决于哪个利润更大。
     * dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i])
     */
    public int maxProfit3(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        // 如果k大于天数的一半，视为可以进行无限次交易
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            return maxProfit;
        }
        int[][] dp = new int[n][2 * k + 1];
        // 初始化买入状态
        for (int i = 1; i <= 2 * k; i += 2) dp[0][i] = -prices[0];
        // 买入状态
        // 卖出状态
        for (int i = 1; i < n; i++)
            for (int j = 1; j <= 2 * k; j++)
                if (j % 2 == 1) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
        return dp[n - 1][2 * k];
    }
}