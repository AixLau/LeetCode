package com.map;

import java.util.LinkedList;
import java.util.Queue;

public class _695 {


    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, i, j));
        return maxArea;
    }

    /**
     * 从矩阵的左上角开始，遍历每个单元格。每当遇到值为 1 的单元格，就意味着可能找到了一个新的岛屿。
     * 从当前的陆地单元格开始，使用 dfs 探索所有相连的陆地。查看当前单元格的上下左右四个方向，每次都尝试深入探索。
     * 在探索过程中，没遇到一个陆地单元格，就将岛屿的面积+1，并将单元格标记为已访问。防止重复计算。
     * 完成一个岛屿的探索后，如果当前岛屿的面积大于之前记录的最大面积，则更新最大面积。
     * 通俗易懂的解释：
     * 想象你在一个游乐园中，每当你发现一个新的游戏区域（岛屿）时，你就会尽可能地探索这个区域的每一个角落（陆地），
     * 知道你确定自己已经玩遍了所有的游戏。每探索一个游戏，就把它从地图上划掉，防止重复玩。
     * 最后你会记下最大的游戏区域是哪个，也就是最大的岛屿面积。
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[i].length || grid[i][j] == 0) return 0;
        int area = 1;
        grid[i][j] = 0;
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i, j + 1);
        return area;
    }

    /**
     * 从矩阵的左上角开始遍历，寻找值为 1 的单元格。
     * 使用一个队列来支持 bfs，每当发现一个陆地单元格，就将其加入队列，并开始探索。
     * 从队列中取出一个单元格，然后检查其上下左右四个方向的相邻单元格。
     * 对于每个未被访问的相邻陆地，将其加入队列并标记已访问。
     * 每次从队列中取出一个陆地单元格时，岛屿面积+1.
     * 完成对一个岛屿的 bfs 探索后，更新最大岛屿面积的记录。
     */
    private int bfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            area++;
            if (x > 0 && grid[x - 1][y] == 1) {
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
            }
        }
        return area;
    }
}
