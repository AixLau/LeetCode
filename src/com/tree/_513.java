package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */

public class _513 {

    public int findBottomLeftValue(TreeNode root) {

        return find(root);
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null)
            ans = root.left.val;
        ans += Math.max(find(root.left), find(root.right));
        return ans;
    }

    /**
     * 用层序遍历
     */
    public int findLeft(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if (i == 0) ans = node.val;
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
            }
        }
        return ans;
    }
}
