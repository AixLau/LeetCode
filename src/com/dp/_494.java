package com.dp;

public class _494 {
    /**
     * 可以被看做是寻找两个子集的问题,这两个子集分别代表+和-号前的数字,使得这两个子集的差等于目标值.
     * 将加号前的数字总和设为 sumPos,减号前的数字总和设为 sumNeg,则有:
     * sumPos - sumNeg = target
     * sumPos + sumNeg = sum
     * sumPos = (target + sum) / 2
     * 这意味着问题转化为了找出 nums 中的子集,期和为(target+sum)/2 的方法数
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 1.初始化: 计算 sum,如果(target+sum)是奇数或者 target > sum,则不可能找到这样的子集,返回 0
        // 2.状态定义:创建动态规划数组 dp,其中 dp[i]表示和为 i 的子集的数量.
        // 3.状态转移: 对于 nums 中的每个数字 num,遍历从(target+sum)/2 到 num的所有 j,更新 dp[j]为 dp[j]+dp[j-num].
        // 这表示当前数字 num 可以加入到和为 j-num 的所有子集中,形成和为 j 的新子集.
        // 4.初始化 dp[0]:表示空子集的数量为 1
        // 5.结果: dp[(target+sum)/2]即为所求答案.
        int sum = 0;
        for (int num : nums) sum += num;
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) return 0;
        int s = (target + sum) / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1; // 空子集的和为 0,只有一种方式.
        for (int num : nums) for (int j = s; j >= num; j--) dp[j] += dp[j - num];
        return dp[s];
    }
}
