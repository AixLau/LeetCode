package com.map;

public class _684 {

    /**
     * 初始化一个并查集，每个节点的父节点是自己。
     * 遍历给定的所有边，对于每一条边[a,b],使用并查集 find 查找 a 和 b 的根节点。
     * 如果 a 和 b 的根节点相同，说明添加这条边会形成换，这条件就是冗余的的边。
     * 如果 a 和 b 的根节点不同，说明添加这条边不会形成环，使用并查集的 union 合并 a 和 b 所在的集合。
     */
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges)
            if (uf.union(edge[0], edge[1])) return edge;
        return new int[0];
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = parent[rootY];
                return false;
            }
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
