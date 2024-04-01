package com.greed;

public class _122 {

    /**
     * 使用贪心算法的思想，即每步都取当前能渠道的最优解
     * （这里是每天比较，如果第二天的价格比今天高，就视为获利并累加）。
     * 这种方式适用于这个问题，因为题目允许进行多次交易且不限交易次数。
     * 初始化 ans=0，用来累计所有获得的利润。
     * 遍历价格数组 prices，对于每个元素 prices[i]，如果 prices[i]小于 prices[i+1]
     * （即明天的价格比今天高），则意味着进行一次买卖能够获利。于是，将 prices[i+1]-prices[i]
     * （即这次买卖获得的利润）加到 ans 上。
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i] < prices[i + 1]) ans += prices[i + 1] - prices[i];
        return ans;
    }
}
