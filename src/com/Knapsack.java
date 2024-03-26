package com;

import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] spaces = new int[M];
        int[] values = new int[M];
        for (int i = 0; i < M; i++) spaces[i] = sc.nextInt();
        for (int i = 0; i < M; i++) values[i] = sc.nextInt();
        System.out.println(knapsack(N, M, spaces, values));
    }

    /**
     * 初始化：
     * dp[0][j]=0: 当没有材料可选时,任何容量的背包的最大价值都是 0.
     * dp[i[0]=0: 当背包容量为 0 时,无法装入任何材料,所以最大价值为 0.
     * 填充 dp 数组:
     * 对于每一种材料 i 和每一种背包容量 j,有两种选择.
     * 不选择当前材料: 此时最大价值与考虑前 i-1 种材料相同,即 dp[i][j] = dp[i-1][j].
     * 选择当前材料: 需要确保背包有足够的空间装下当前材料(j>=spaces[i-1]).
     * 此时的最大价值是当前材料加上剩余空间能达到的最大价值,即dp[i-1][j-spaces[i-1]] + values[i-1].
     */
    public static int knapsack(int n, int m, int[] spaces, int[] values) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (j < spaces[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - spaces[i - 1]] + values[i - 1]);
        return dp[m][n];
    }
}