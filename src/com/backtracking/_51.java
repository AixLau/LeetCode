package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _51 {

    List<List<String>> result = new ArrayList<>();
    private boolean[] usedCol;
    private boolean[] usedDiag45;
    private boolean[] usedDiag135;

    public List<List<String>> solveNQueens(int n) {
        usedCol = new boolean[n];
        usedDiag45 = new boolean[2 * n - 1];
        usedDiag135 = new boolean[2 * n - 1];
        // 初始化期盼，使用一个二维数组表示，初始填充为 '.' 表示空位。
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
        backtrack(board, n, 0);
        return result;
    }

    /**
     * 从第一行开始，尝试在每一行放置一个皇后，并为每个合法位置递归调用回溯函数，尝试下一行。
     * 继续这个过程，直到所有的皇后都被放置在棋盘上，形成一个解决方案，或者回溯到上一个状态尝试新的位置。
     * 在放置每个皇后之前，检查当前位置是否安全（即该位置是否在其他皇后的攻击范围内）。
     * 这包括检查同一行、同一列以及两个对角线方向上是否已经安置了皇后。
     * 每当找到一种有效的棋盘布局时，将其添加到解决方案列表中。
     */
    private void backtrack(char[][] board, int n, int row) {
        // 如果当前行号等于 n，说明已经成功放置了 n 个皇后，找到了一个解决方案
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            // 检查在（row，col）位置放置皇后是否安全
            // 不安全就跳过
            if (!isSafe(board, row, col, n)) continue;
            board[row][col] = 'Q';
            backtrack(board, n, row + 1);
            board[row][col] = '.';
        }
    }

    /**
     * 使用三个数组来快速判断某一列或对角线上是否已经放置了 皇后，从而避免冲突。
     * 这种方法不仅使得检查是否安全更加高效，而且也简化了回溯的过程
     * usedCol：表示棋盘上的列是否被占用。如果 usedCOl[col] 为 true 表示第 col 列已经放置了皇后
     * usedDiag45：表示棋盘上的 45 度对角线是否被占用。这个数组的关键在于理解棋盘上任意两个处于同一 45 度对角线上的点
     * （row1，col1）和（row2，col2）满足 row1+col2==row2+col2.这意味着可以通过 row+col 的值唯一标一条45 对角线
     * usedDiag135：表示棋盘上的 135 对角线是否被占用。对于任意两个处于同一 135 对角线上的点（row1，col1）和（row2，col2），
     * 它们满足 row1-col1==row2-col2。由于 row-col 的值可能是负数，为了能够使用数组的索引，我们对其进行了偏移，加上 n-1 使得索引始终是非负的。
     * 对于棋盘上最左上角的格子（0，0），row-col 的值是 0。
     * 对于棋盘上最左下角的格子（n-1, 0），row-col 的值是 n-1。
     * 对于棋盘上最右上角的格子（0，n-1），row-col 的值是 -（n-1）；
     * 最小可能值 -(n-1) 映射到 0（因为 -(n-1) + (n-1) = 0）。
     * 0 映射到 n-1（因为 0 + (n-1) = n-1）。
     * 最大可能值 +(n-1) 映射到 2*(n-1)（因为 +(n-1) + (n-1) = 2*(n-1)）。
     */

    private void backtracking(char[][] board, int n, int row) {
        if (n == row) result.add(construct(board));
        for (int col = 0; col < n; col++) {
            if (usedCol[col] || usedDiag45[row + col] || usedDiag135[row - col]) continue;
            board[row][col] = 'Q';
            usedCol[col] = true;
            usedDiag45[row + col] = true;
            usedDiag135[row - col] = true;
            backtrack(board, n, row + 1);
            usedCol[col] = false;
            usedDiag45[row + col] = false;
            usedDiag135[row - col] = false;
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // 检查同一列上方是否有皇后
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;

        // 检查左对角线上是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;

        // 检查右上角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
        // 如果上面的检查都通过了，说明这个位置时安全的，可以放置皇后
        return true;
    }

    // 将期盼转为字符串列表
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) res.add(new String(chars));
        return res;
    }
}
