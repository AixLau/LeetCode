package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _111 {
    /**
     * bfs
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth = Integer.MAX_VALUE;
        if (root.left != null) depth = Math.min(depth, minDepth(root.left));
        if (root.right != null) depth = Math.min(depth, minDepth(root.right));
        return depth + 1;
    }


    /**
     * dfs
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        int depth = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = dq.poll();
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                if (node.left == null && node.right == null) return depth;

            }
        }
        return depth;
    }
}
