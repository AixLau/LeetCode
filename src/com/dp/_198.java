package com.dp;

public class _198 {

    /**
     * 核心思想是，对于每一间房子，小偷有两个选择：偷这间房子，或者不偷这间房子。
     * 如果偷了这间房子，那么不就不能偷前一间房子；如果不偷这间房子，那么总金额就是前一间房子最大偷窃金额。
     * 解题思路：
     * 定义状态：假设 dp[i]表示到达 i 个房子时能偷窃到最大金额，其中 0<=i<nums.length。
     * 状态转移：
     * 如果选择偷第 i 间房子，则不能偷 i-1 间房子，所有 dp[i]=dp[i-2]+nums[i]
     * 如果不偷第 i 间房子，则 dp[i]=dp[i-1]
     * 综上所述，dp[i] = max(dp[i-1], dp[i-2] + nums[i])
     * 初始化：
     * dp[0]=nums[0]，因为只有一个房子时，只能偷这房子。
     * 如果房子数量大于 1，dp[1]=max(nums[0],nums[1])，因为只能偷着两个房子中金额较大的那一个。
     * 迭代填表：从 i=2，开始迭代，直到 i=nums.length-1，根据状态转移方程更新 dp[i]。
     * dp[nums.length-1]表示最后一个房子能偷窃到的最大金额。
     */
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[nums.length - 1];
    }
}
