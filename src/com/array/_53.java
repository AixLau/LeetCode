package com.array;

public class _53 {

    /**
     * 如果 nums 只包含一个元素，直接返回这个元素值。
     * result 初始化为Integer.MIN_VALUE 却表能被任何其他数更新，
     * cnt 初始化为 0，准备累加子数组的和。
     * 遍历 nums 如果 nums 加上cnt 大于 result，说明找到了一个更大的子数组和，
     * 更新 result 为 cnt 的值。
     * 如果 cnt 变为负数，意味着当前累加的子数组将不可能是最大子数组
     * （因为任何包含它的更大数组都会被减少）重置 cnt 为 0，从下一个元素重新开始计算数组的和
     * 算法的核心思想是：
     * 在遍历数组的过程中，连续地计算当前最大子数组和，并且在遇到子数组和变为负数时放弃当前子数组，
     * 从下一个元素开始尝试心得子数组。这时因为任何包含当前负和子数组的更大数组，
     * 其他和都不会超过从下一个元素开始的子数组和。
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int cnt = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            cnt += num;
            if (cnt > result) result = cnt;
            if (cnt < 0) cnt = 0;
        }
        return result;
    }

    /**
     * 代码核心思想在于 cnt 和 result 的更新逻辑：
     * cnt 记录当前考虑元素的结尾的最大数组和。如果加上当前元素后的和比当前元素自身小，
     * 那么就从单签元素重新开始计算和，因为当前元素自身构成一个更大的子数组和。
     * result 则是在整过程中找到的最大子数组和，它在一步都会与 cnt 进行比较，并保持最大值。
     */
    public int maxSubArrays(int[] nums) {
        int result = nums[0];
        int cnt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cnt = Math.max(nums[i], cnt + nums[i]);
            result = Math.max(cnt, result);
        }
        return result;
    }
}
