package com;

public class _704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (right + left) >> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle-1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("new _704().search(new int[]{-1, 0, 3, 5, 9, 12}, 9) = "
                + new _704().search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
