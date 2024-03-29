package com.dp;

import java.util.Scanner;

/**
 * 题目描述：
 * 假设你正在爬楼梯，需要爬 n 阶才能到达楼顶。每次你都可以爬 m 个台阶。（1<=m<n）
 * 你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairsPro {
    /**
     * 定义状态：dp[i]表示到达第 i 阶楼梯的方法数
     * 初始化：dp[0]=1，因为达到 0 阶（实际上是起点）只有一种方法，即不爬任何阶梯。
     * 对于 1 至m 阶，如果 i<=m，那么它的方法数是前 i-1 阶方法数的总和。
     * 状态转移：
     * 如果 i>m，则dp[i] = dp[i-1] + dp[i-2] + ... + dp[i-m]。
     * 意味着到达第 i 阶的方法数是前 m 个 dp 值的总和。
     */
    private static int climStairs(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m && j <= i; j++)
                dp[i] += dp[i - j];
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(climStairs(n, m));
    }
}
