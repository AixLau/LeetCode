package com.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _827 {
    int n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 找出所有的岛屿并计算它们的面积。
     * 把同一个岛屿的格子都标记为相同的岛屿编号
     * 寻找可以链接两个或多个岛屿的 0 格子
     * 对于每个 0 格子，计算它变成 1 能连接的所有面积之和再加上 1（这个格子本身）
     * 在所有这样的 0 格子中找出能得到最大的岛屿面积。
     * 如果整个网格中没有 0，那么最大的岛屿面积就是整个网格面积
     */
    public int largestIsland(int[][] grid) {
        n = grid.length;
        int maxArea = 0;
        Map<Integer, Integer> areaMap = new HashMap<>(); //岛屿编号到面积的映射
        int islandId = 2; //从 2 开始，因为 0 和 1 已经有含义了
        // 1.找出岛屿并计算它们的面积
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId++, area);
                    maxArea = Math.max(maxArea, area);
                }
        // 2.寻找可以链接岛屿 0 格子并计算最大面积
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) {
                    Set<Integer> connectedIslands = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        // 检查邻接单元格是否在网格范围内，且该邻接单元格属于某个岛屿（即岛屿编号大于1）
                        // 使用 set 集合避免重复计算相同岛屿面积
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) connectedIslands.add(grid[x][y]);
                    }
                    int connectArea = 1; // 当前 0 格子变为 1
                    for (Integer id : connectedIslands) connectArea += areaMap.get(id);
                    maxArea = Math.max(maxArea, connectArea);
                }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int area = 1;
        for (int[] dir : dirs) area += dfs(grid, i + dir[0], j + dir[1], islandId);
        return area;
    }
}
