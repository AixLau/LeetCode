package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _429 {
        List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node node = dq.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    dq.offer(child);
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }

    public void dfs(Node root, int deep) {
        if (root == null) return;
        deep++;
        if (result.size() < deep) {
            result.add(new ArrayList<>());
        }
        result.get(deep - 1).add(root.val);
        for (Node child : root.children) {
            dfs(child, deep);
        }
    }
}

class Node{
    public int val;
    public List<Node> children;
    public Node(){}

    public Node(int val
    ) {
        this.val = val;
    }
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}