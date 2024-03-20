package com.map;

import com.tree.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _417 {

    int m, n;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 逆向思维策略：
     * 从两个目的地（太平洋和大西洋）的边缘出发，逆流而上找到可以到达的源头。
     * 如果某个单元格开始，水能够逆流而上到达海洋，那么反过来，从海洋出发，这个单元格也一定是水能到达的地方。
     * 初始化两个标记矩阵，用于分别标记能够流入太平洋和大西洋的岛屿单元格。
     * 从大洋边缘开始的逆向搜索：逆流而上探索每个单元格。
     * 逆流的条件是当前单元格的高度必须大于或等于前一个单元格的高度，这样水才可能从当前单元格流到前一个单元格。
     * 一旦满足逆流条件，当前单元格就会被标记为可流入相应的大洋。
     * 对于同时被标记为可流入太平洋和大西洋的单元格，将它们的坐标加入到最终结果列表中。
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, n - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, pacific, Integer.MIN_VALUE);
            dfs(heights, m - 1, i, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int prevHeight) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || heights[i][j] < prevHeight) return;
        visited[i][j] = true;
        for (int[] dir : dirs) dfs(heights, i + dir[0], j + dir[1], visited, heights[i][j]);
    }

    private void bfs(int[][] heights, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int prevHeight;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            visited[x][y] = true;
            prevHeight = heights[i][j];
            if (i > 0 || i < m || j > 0 || j <= n || visited[i][j] || heights[i][j] < prevHeight)
                for (int[] dir : dirs) dfs(heights, i + dir[0], j + dir[1], visited, heights[i][j]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5}};
        _417 v = new _417();

        System.out.println(v.pacificAtlantic(heights));


    }
}