package com.dp;

public class _746 {

    /**
     * dp[i]表示到达第 i 个台阶所需的最低花费。
     * 对于每个台阶 i，都可以从 i-1 或 i-2 个台阶到达它，
     * 因此到达 i 个台阶的最低花费就是 dp[i] = min(dp[i-1],dp[i-2])+cost[i]。
     * 由于可以选择第 0 或 1 个台阶开始，所以 dp[0]=cost[0] dp[1]= cost[1]。
     * 从第二个台阶开始计算，一直到最后一个台阶。
     * 到达楼梯顶部即超过最后一个台阶，所以最低话费是 min[dp[n-1],dp[n-2]),
     * 其中 n 是数组 cost 的长度
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
