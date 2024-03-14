package com.array;

public class _209 {
    /**
     * 该题使用滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口数值之和
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 当sum值大于等于target值时，比较一下当前sum和result哪个小，将小的值在存入到result当中
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                // 将sum - left当前值，然后将left往前滑动
                sum-=nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
