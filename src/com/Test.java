package com;


import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[][] nums = new int[5][2];
        nums[0][1] = 1;
        System.out.println(nums.length);
        for (int[] num : nums) System.out.println(Arrays.toString(num));

    }

    // 检查一个数是否是素数
    private static boolean isPrime(int numerator, int denominator) {
        int result = numerator / denominator; // 计算除法结果
        if (result < 2) return false; // 小于2不是素数
        for (int i = 2; i <= Math.sqrt(result); i++) if (result % i == 0) return false; // 如果能被除以除了1和它本身之外的数，则不是素数
        return true; // 是素数
    }
}

