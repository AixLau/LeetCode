package com.map;

import java.util.LinkedList;
import java.util.Queue;

public class _1020 {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            bfs(grid, i, 0);
            bfs(grid, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            bfs(grid, 0, i);
            bfs(grid, m - 1, i);
        }
        for (int[] ints : grid) for (int j = 0; j < n; j++) if (ints[j] == 1) count++;
        return count;
    }

    /**
     * 核心思路是反向思考问题：
     * 寻找那些能够直接或间接通过相邻的陆地单元到达边界的陆地单元格，然后将它们标记为已访问。
     * 最后，网格中未被标记为已访问的陆地单元格就是无法离开网格边界的陆地单元格。
     */
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private void bfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        grid[i][j] = 0;
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                    grid[newX][newY] = 0;
                    queue.offer(new int[]{newX, newY});
                }
            }
           /*  if (x > 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 0;
                queue.offer(new int[]{x - 1, y});
            }
            if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 0;
                queue.offer(new int[]{x + 1, y});
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 0;
                queue.offer(new int[]{x, y - 1});
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 0;
                queue.offer(new int[]{x, y + 1});
            } */
        }
    }
}
