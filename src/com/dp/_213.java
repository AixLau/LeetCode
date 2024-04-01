package com.dp;

public class _213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length - 1));
    }

    /**
     * 这个方法计算从 start 到 end 能偷窃到的最大金额。
     * 定义两个变量 first：当前房屋为止的偷窃最大金额，second：前一个房屋为止的偷窃最大金额。
     * 对于每个房屋 i，有两种选择：偷或不偷。
     * 如果偷了第 i 个房间，那么最大金额是第 i-2 个房屋的最大金额加上当前房屋的金额（因为相邻的房屋不能偷）。
     * 如果不偷第 i 个房间，那么最大金额是第 i-1 个房屋为止的最大金额。
     * 使用 current 来保存偷窃第 i 个房间时能得到的最大金额，然后更新 first 和 second。
     * 最终，first 会保存整个范围内能偷窃到的最大金额。
     */
    private int robRange(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = end; i >= start; i--) {
            int current = Math.max(first, second + nums[i]);
            second = first;
            first = current;
        }
        return first;
    }
}
