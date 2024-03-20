package com.map;

import java.util.LinkedList;
import java.util.Queue;

public class _200 {
    public int numIslands(char[][] grid) {
        // 如果网格为空或网格的长度为0，返回0表示没有岛屿
        if (grid == null || grid.length == 0) return 0;
        int num = 0;

        for (int i = 0; i < grid.length; i++)
            // 如果当前单元格是陆地（值为‘1’）
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {
                    // 使用dfs将所有与之相连的陆地标记为已访问
                    dfs(grid, i, j);
                    // 每完成一次dfs，岛屿数量+1
                    num++;
                }
        return num;
    }

    /**
     * dfs帮助我们访问每一个陆地党员个，并且标记所有与它相连的陆地单元格，一次来识别一个岛屿。
     * 一旦访问了一个陆地单元格，就将其标记为已访问，这样不就不会再次将其计入岛屿数量中。
     * 遍历给定的二维网格。对于每个单元格，如果它是陆地，那么就找到一个尚未被访问的岛屿的一部分。
     * 从当前的陆地单元开始，执行深度优先搜索，访问所有相邻的、未被访问的陆地单元格。
     * 包括上下左右四个方向的相邻党员个。将访问过的陆地单元格标记为已访问，以避免重复计算。
     * 这可以通过将单元格的值从1改为0或其他标记值来实现。
     * 当dfs完成时，意味着已经访问了与当前陆地相连的所有陆地单元格，即完成了对一个岛屿的搜索与标记。
     * 因此岛屿数量+1。
     */
    // 用于标记与当前陆地单元格相连的所有陆地单元格
    public void dfs(char[][] grid, int i, int j) {
        // 检查索引是否越界或当前单元格是否为水’0‘，如果是，则返回
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        // 将当前陆地单元格标记为已访问（这里将其设置为0来表示）
        grid[i][j] = '0';
        // 递归调用dfs，探索当前单元格的上下左右四个方向的相邻单元格
        dfs(grid, i + 1, j); // 下
        dfs(grid, i - 1, j); // 上
        dfs(grid, i, j + 1); // 右
        dfs(grid, i, j - 1); // 左
    }

    /**
     * 对于网格中的每个单元格，如果它是陆地，则启动一次bfs搜索。
     * 将当前陆地单元格加入队列，并将其标记为已访问（即将其设置为0）
     * 从队列中取出一个单元格，检查其上下左右的相邻但愿。对于每个未被访问的相邻陆地单元格，
     * 将其加入队列并标记为已访问。
     * 重复步骤3，直到队列为空，这意味这已经访问了当前岛屿的所有单元格。
     * 岛屿数量+1
     */
    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            if (x > 0 && grid[x - 1][y] == '1') {
                queue.offer(new int[]{x - 1, y});
                grid[x - 1][y] = '0';
            }
            if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                queue.offer(new int[]{x + 1, y});
                grid[x + 1][y] = '0';
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                queue.offer(new int[]{x, y - 1});
                grid[x][y - 1] = '0';
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
                queue.offer(new int[]{x, y + 1});
                grid[x][y + 1] = '0';
            }
        }
    }
}
