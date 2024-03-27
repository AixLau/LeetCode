package com.dp;

import java.util.Arrays;

public class _1049 {
    /**
     * dp[j] 代表在总重量不超过 j 的条件下,所能选择的石头最大总重量.
     * 动态规划逻辑:
     * 外层循环遍历每块石头
     * 内层循环从 target 到当前石头的重量 stone.
     * 这里需要反向遍历,确保每块石头只被计算一次.
     * 更新 dp[j]: 比较不选当前石头时的重量 dp[j]和选 了当前石头的最大重量 dp[j-store[i]+stone,取二者较大值.
     * 最终 dp[target]代表总重量不超过 target 时所能达到的最大重量,而 sum-2*dp[target]即为最后剩下的石头的最小可能重量.
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            System.out.println(Arrays.toString(dp));
        }
        return sum - 2 * dp[target];
    }

    public static void main(String[] args) {
        _1049 v = new _1049();
        v.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});

    }
}
