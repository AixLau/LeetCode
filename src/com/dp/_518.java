package com.dp;

public class _518 {
    /**
     * 定义状态：dp[i]表示总金额为 i 时的硬币组合数。
     * 状态转移：对于每种硬币，我们都有选和不选两种选择。
     * 因为我们需要累加使用不同硬币达到金额 i 的方法数。
     * 如果使用一枚面额为 coin 的硬币，状态转移方程为dp[i] += dp[i - coin]，其中 i 需要大于或等于 coin。
     * 初始化：dp[1]=1 表示总金额为 0 时有一种方法（不使用任何硬币），其他 dp[i]初始化为 0。
     * 循环：先遍历 coins，对于每 coin，再遍历 coin 到 amount 的 i，更新 dp[i]。
     * 返回结果：dp[amount]就是总金额为 amount 的硬币组合数。
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++) dp[i] += dp[i - coin];
        return dp[amount];
    }
}
