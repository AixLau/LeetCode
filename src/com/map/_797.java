package com.map;

import java.util.ArrayList;
import java.util.List;

public class _797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 检查当前节点 node 是否是目标节点。如果是，那么找到了一条路径，将其添加到结果列表中。
     * 如果当前节点不是目标节点，遍历当前节点的所有邻接节点（也就是可以直接到达的节点）。
     * 对于每个邻接节点，先将它添加到当前路径中，然后调用递归方法继续探索从下一个节点出发的路径。
     * 一旦从 dfs 方法返回，移除路径中最后一个节点，这时因为已经探索完从该节点出发的所有路径，
     * 需要回溯到上一个节点探索其他可能得路径。
     */
    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {
            // 到达目标节点，添加当前路径到结果列表
            result.add(new ArrayList<>(path));
            return;
        }
        for (int nexNode : graph[node]) {
            path.add(nexNode); // 添加节点到当前路径
            dfs(graph, nexNode);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
