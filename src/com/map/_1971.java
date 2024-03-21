package com.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 构造图的邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n]; // 记录访问状态
        return dfs(source, destination, adj, visited);
    }

    /**
     * 从一个顶点开始，访问其任一邻接接未访问过的顶点，标记它为已访问，
     * 当无法继续深入时（即该顶点的所有邻接顶点都访问过了），回溯到上一个顶点，
     * 继续尝试其他的路径。持续到所有的顶点都被访问过，或找到所需的顶点或路径
     */
    private boolean dfs(int source, int destination, List<List<Integer>> adj, boolean[] visited) {
        if (source == destination) return true; // 找到路径
        visited[source] = true;
        for (int next : adj.get(source)) if (!visited[next] && dfs(next, destination, adj, visited)) return true;
        return false;
    }

    /**
     * 使用一个队列按顺序存储带访问的顶点。
     * 对于队列中的每个顶点，检查它是否是目标的顶点。
     * 如果是，搜索结束，返回 true。
     * 如果不是，将其所有未访问过的邻接顶点加入队列。
     * 如果队列最终变空，意味着没有找到从源到目标的路径，返回 false。
     */
    private boolean bfs(int source, int destination, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;
            for (int next : adj.get(current))
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
        }
        return false;
    }

    /**
     * 并查集类
     */
    static class UnionFind {
        private int[] parent;

        // 构造函数，初始化 n 个元素的并查集
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i; // 初始时，每个元素的父亲点是自己
        }

        // 查找元素 x 的根节点
        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        // 将元素 x 和元素 y 所在的集合合并
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) parent[rootX] = rootY;
        }

        // 检查 x 和 y 是否属于同一个集合
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    /**
     * 初始化并查集：创建一个大小为 n 的并查集，每个顶点最开始指向自己，表示格子处于不同的连通分量中。
     * 构建图的连通性，遍历所有的边，使用并查集的 union 操作将每条边的两个顶点连接起来。
     * 这一步是在逻辑上将两个顶点属于同一个连通分量。
     * 使用并查集的 find 操作检查 source 和 destination 是否属于同一个连通分量。
     * 如果是，则存在从 source 到 destination 的路径，否则不存在。
     * 并查集的核心方法
     * find：找到某个顶点的根顶点（连通分量的代表）。如果顶点直接指向自己，则它就是自己的根。
     * 否则，递归地找到它的根。为了优化，使用路径压缩技术，即在查找过程中，将顶点直接链接到其根顶点，减少后续查找的层数。
     * union：合并两个顶点所在的连通分量。首先使用 find 方法找到两个顶点的根，
     * 如果根顶点不同，就将一个跟顶点指向另一个，从而实现量连通分量的合并。
     * connected：判断两个顶点是否连通，即它们是否属于同一个连通分量。
     * 如果两个顶点的根顶点相同，则它们连通。
     */
    public boolean valid(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        return uf.connected(source, destination);
    }

    public static void main(String[] args) {
        _1971 v = new _1971();
        System.out.println(v.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
    }
}
