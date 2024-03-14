package com.greed;


import java.util.Arrays;

public class _1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //将数组中的元素按照绝对值大小进行降序。
        // 为了优先对绝对值大的负数进行取反操作。
        nums = Arrays.stream(nums).boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < nums.length; i++)
            // 如果还有取反操作机会，并且当前元素是负数，进行取反
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        // 如果取反操作还有剩余（即 k 为奇数时）则对数组中最小元素（位于数组末端）进行取反
        if (k % 2 == 1) nums[nums.length - 1] = -nums[nums.length - 1];
        return Arrays.stream(nums).sum();
    }
}
