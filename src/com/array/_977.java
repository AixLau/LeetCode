package com.array;

import java.util.Arrays;

public class _977 {
    // 首先使用暴力破解法 解题
    public int[] sortedSquares(int[] nums) {
        int[] newN = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = (int) Math.pow(nums[i], 2);
            newN[i] = num;
        }
        Arrays.sort(newN);
        return newN;
    }

    /**
     * 尝试使用双指针解题
     * 定义头尾两个指针，因为是平方所以负数的平方之后会变为正树，判断首尾两个数，谁大就先插入哪个数
     */
    public int[] sortedSquares2(int[] nums) {
        int start = 0, end = nums.length - 1, middle = (end - start) >> 1;
        int[] newN = new int[nums.length];
        int i = nums.length - 1;
        while (start <= end) {
            int a = (int) Math.pow(nums[start], 2);
            int b = (int) Math.pow(nums[end], 2);
            if (a > b) {
                newN[i] = a;
                start++;
            } else {
                newN[i] = b;
                end--;
            }
            i--;

        }
        return newN;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _977().sortedSquares2(new int[]{-4, -1, 0, 3, 10})));
    }
}
