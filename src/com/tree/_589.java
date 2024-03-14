package com.tree;

import java.util.*;

public class _589 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        pre(root);
        return ans;
    }

    public void dfs(Node root) {
        if (root == null) return;
        ans.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }

    public void pre(Node root) {
        if (root == null) return;
        Deque<Node> dq = new ArrayDeque<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            ans.add(node.val);
            // 从右到左将子节点压入栈中，
            Collections.reverse(node.children);
            for (Node child : node.children) {
                dq.push(child);
            }
        }
    }
}
