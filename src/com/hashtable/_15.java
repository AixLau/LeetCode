package com.hashtable;

import java.util.*;

public class _15 {
    /**
     * 使用 排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 将 nums 排序 -4 -1 -1 0 1 2
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果排序后的第一个元素大于0说明后面没有负数 永远都无法成为三元组
            if (nums[i] > 0) {
                return ans;
            }
            // 如果当前的值 a 与前面的值相等 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 依然还是在数组中找到 abc 使得a + b +c =0，
                // 我们这里相当于 a = nums[i]，b = nums[left]，c = nums[right]。
                int sum = nums[i] + nums[left] + nums[right];
                // 如果nums[i] + nums[left] + nums[right] > 0
                // 就说明 此时三数之和大了，因为数组是排序后了，
                // 所以right下标就应该向左移动，这样才能让三数之和小一些。
                if (sum > 0) {
                    right--;
                    // 如果 nums[i] + nums[left] + nums[right] < 0
                    // 说明 此时 三数之和小了，left 就向右移动，
                    // 才能让三数之和大一些，直到left与right相遇为止。
                } else if (sum < 0) {
                    left++;
                } else {
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _15 v = new _15();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(v.threeSum(num));
    }
}
