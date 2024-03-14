package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class _404 {
    public int sumOfLeftLeaves(TreeNode root) {
        // return iteration(root);
        return sumLeftLeaves(root);
    }

    /**
     * 当一个节点是其父节点的左子节点，并且没有自己的左右子节点时，它就是一个左叶子节点。
     */

    public int sumLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null) sum += root.left.val;
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }

    public int iteration(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.pop();
            if (node.left != null && node.left.left == null && node.left.right == null)
                sum += node.left.val;
            if (node.right != null) dq.push(node.right);
            if (node.left != null &&
                    (node.left.left != null || node.left.right != null))
                dq.push(node.left);
        }
        return sum;
    }

    /**
     * 层序遍历
     */
    public int iteration2(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                TreeNode node = dq.poll();
                if (node.left != null &&
                        node.left.left == null &&
                        node.left.right == null)
                    sum += node.left.val;
                if (node.right != null) dq.offer(node.right);
                if (node.left != null &&
                        (node.left.left != null || node.left.right != null)) dq.offer(node.left);
            }
        }
        return sum;
    }
}
