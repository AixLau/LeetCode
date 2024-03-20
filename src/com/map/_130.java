package com.map;

import java.util.LinkedList;
import java.util.Queue;

public class _130 {
    private int m, n;

    /**
     * 基本思路是从边缘的 O 出发，找到所有与边缘 O 相连的 O，
     * 这些 O 不会被 X 包围，将它们标记为另一个字符。
     * 矩阵中剩余的 O 都是被 X 包围的，将它们替换为 X，
     * 再把标记过的Y 恢复成 O。
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'Y';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    private void bfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X') return;
        Queue<int[]> queue = new LinkedList<>();
        board[i][j] = 'Y';
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            for (int[] dir : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newX = dir[0] + x, newY = dir[1] + y;
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && board[newX][newY] == 'O') {
                    board[newX][newY] = 'Y';
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
