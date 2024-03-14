package com.tree;


import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;

public class _590 {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        return null;
    }

    public void dfs(Node root) {
        if (root==null)return;
        for (Node child : root.children) {
            dfs(child);
        }
        ans.add(root.val);
    }

    /**
     * 后序遍历
     * 将前序遍历反转数组
     */
    public void post(Node root) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            Node node = dq.pop();
            ans.add(node.val);
            for (Node child : node.children) {
                dq.push(child);
            }
        }
        Collections.reverse(ans);
    }
}
