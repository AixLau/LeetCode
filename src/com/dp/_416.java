package com.dp;

public class _416 {

    /**
     * 基本思路是利用0-1 背包问题的变种来解决.
     * 尝试找到一个子集,其元素之和等于真个数组元素的一半.
     * 如果可以找到这样的子集,那么剩下的元素自然形成另一个和相等的子集.
     * 首先计算数组 nums 的总和.
     * 如果总和是奇数,则不可能分割成两个相等的子集,直接返回 false.
     * 如果和是偶数,那么每个子集的目标和就是总和的一半.
     * 使用 dp 来找出是否存在一个子集,其和等于总和的一半.
     * 创建一个布尔数组 dp,其中 dp[i]表示数组是否可以取出一些数组,使得它们的和为 i.
     * 初始化 dp[0]=true(因为取 0 个数字的和为 0,总是可能得)其余为 false.
     * 遍历每个数字,对于每个数字,从总和的一半开始向下遍历找到该数字的值,更新 dp 数组
     * 如果 dp[j-sum]为 true,则 dp[j]也为 true.
     * 最后 dp[target]将告诉我们是否从数组中找到 target 的子集
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) for (int i = target; i >= num; i--) dp[i] = dp[i] || dp[i - num];
        return dp[target];
    }

    public boolean canPartition2(int[] nums) {
        // 如果数组为空,直接返回 false.
        if (nums == null || nums.length == 0) return false;
        // 遍历 nums,计算所有元素的总和 sum
        int sum = 0;
        for (int num : nums) sum += num;
        // 如果 sum 是奇数,无法分割成两个和相等的子集,直接返回 false.
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        // dp[j] 代表通过选择 nums 中的一些元素,能够达到的最大总和为 j.
        int[] dp = new int[target + 1];
        /*
           动态规划求解:
           遍历 nums 中的每个元素.
           对于每个元素 nums[i],从 target 倒序遍历到nums[i](确保每个元素只被使用一次),更新 dp[j].
           更新规则: dp[j] = Math.max[dp[j], dp[j-nums[i]] + nums[i]);
           这个更新尝试回答这个问题: 对于当前的 j(子集和的目标值),是否选择当前元素 nums[i] 可以获得更大的子集和.
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            // 剪枝优化: 在每次内循环后立即检查dp[target]是否等于 target.如果等于,可以提前结束循环.
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        _416 v = new _416();
        int[] ints = {1, 5, 11, 5};
        System.out.println(v.canPartition2(ints));
    }
}
