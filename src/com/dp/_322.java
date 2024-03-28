package com.dp;

import java.util.Arrays;

public class _322 {
    /**
     * 如果 amount=0 的话，直接返回 0。
     * 定义一个 dp 数组，其中 dp[i] 表示达到金额 i 所需的最少硬币数量。
     * 初始化 dp[0]以外的所有元素赋值一个大数（例如 amount+1）以表示初始时除了 0 之外，其它金额所需最少硬币数未知。
     * 状态转移：对于每个金额 i 从 1 到 amount，遍历每个硬币面额 coin。
     * 如果 i-coin>=0，则尝试 dp[i] 为 min(dp[i], dp[i - coin] + 1)。
     * 这表示如果当前金额 i 可以由当前硬币面额 coin 加上某个金额 i-coin 达成，且所需硬币数量更少，则更新 dp[i]。
     * 最终 dp[amount]表示达到目标金额所需的最少硬币数。
     * 如果 dp[amount]值仍为初始化的大数，则说明无法用给定的硬币组合凑出目标金额，返回-1，否则返回 dp[amount]。
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
