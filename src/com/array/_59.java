package com.array;

public class _59 {
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;
        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 从右往左
            for (; j > 0; j--) {
                res[i][j] = count++;
            }

            // 从左下往上
            for (; i > 0; j--) {
                res[i][j] = count++;
            }

        }
        if (n % 2 == 1) {
            res[start][start] =count;
        }
        return res;
    }
}
