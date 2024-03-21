package com.map;

import java.util.LinkedList;
import java.util.Queue;

public class _463 {
    int m, n;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (grid[i][j] == 1) return dfs(grid, i, j);
        return 0;
    }

    /**
     * 从网格的左上角开始遍历，查找标记为 1 的格子，这些格子代表岛屿的一部分。
     * 找到岛屿的第一个部分后，从该格子出发进行 dfs，计算岛屿的周长。
     * 对每个正在访问的陆地格子，检查四周的格子。
     * 如果相邻是水，或这该格子位于网格的边界，则认为这条边对岛屿周长有贡献，贡献值为 1。
     * 如果相邻格子是陆地，则继续搜索。
     * 为避免重复计算，访问过的陆地格子会被标记为-1。
     * 累加每个陆地格子四周对周长的贡献，得到整个岛屿的周长。
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;
        int cnt = 0;
        grid[i][j] = -1;
        for (int[] dir : dirs) cnt += dfs(grid, i + dir[0], j + dir[1]);
        return cnt;
    }

    /**
     * 找到网格中的一个陆地格子作为 bfs 的起始点。然后初始化一个队列用于 bfs 遍历，
     * 同时标记起始格子为已访问（将其设置为-1 或使用 visited 数组标记）。
     * 从起始格子开始，将其加入队列。当队列不为空时，执行以下操作：
     * 从队列中取出一个格子。
     * 如歌相邻格子是水域或者越界，说明当前各自的这边是岛屿的边界，因此周长+1。
     * 如果相邻格子是未被访问的陆地，将其加入队列并标记已访问。
     * 时间复杂度 O(M*N)
     */
    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = -1;
        int perimeter = 0;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == 0) perimeter++;
                else if (grid[nextX][nextY] == 1) {
                    queue.offer(new int[]{nextX, nextY});
                    grid[nextX][nextY] = -1;
                }
            }
        }
        return perimeter;
    }
}
