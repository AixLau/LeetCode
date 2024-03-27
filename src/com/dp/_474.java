package com.dp;

public class _474 {
    /**
     * 定义状态：使用二维数组 dp[i][j]表示当前限制条件 i 个 0 和 j 个 1 时的最大子集长度。
     * 状态转移：对于每个字符串，有两种选择：
     * 如果选择不包括当前字符串，则 dp[i][j]保持不变，即dp[i][j] = dp[i][j]。
     * 如果选择包括当前字符串，则需要更新状态。假设当前字符串中包含 x 个0 和 y 个1，
     * 则更新方式为dp[i][j] = max(dp[i][j], 1 + dp[i-x][j-y])
     * 我们初始化dp[0][0] = 0，表示当限制条件为0个0和0个1时，子集长度为0。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = countZeroesOnes(str);
            for (int i = m; i >= count[0]; i--)
                for (int j = n; j >= count[1]; j--)
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
        }
        return dp[m][n];
    }

    private int[] countZeroesOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) count[c - '0']++;
        return count;
    }
}
