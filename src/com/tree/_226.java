package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _226 {
    public TreeNode invertTree(TreeNode root) {
        bfs(root);
        dfs(root);
        bfs(root);
        return root;
    }

    /**
     * dfs 递归
     * 前后序遍历都可以
     */
    public void dfs(TreeNode root) {
        if (root == null) return;
        swap(root);
        dfs(root.left);
        dfs(root.right);
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * bfs
     */
    public void bfs(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                TreeNode node = dq.poll();
                swap(node);
                if (node.left != null) {
                    dq.offer(node.left);
                }
                if (node.right != null) {
                    dq.offer(node.right);
                }
            }
        }
    }
}
