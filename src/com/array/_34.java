package com.array;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int[] violence = violence(nums, target);
        int[] result = {-1, -1};
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    public int[] violence(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) result[0] = i;
                result[1] = i;
            }
        }
        return result;
    }

    public int findFirst(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length- 1;
        while (left <= right) {
            int mid = right + left >> 1;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public int findLast(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length- 1;
        while (left <= right) {
            int mid = right + left >> 1;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}
