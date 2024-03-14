package com.tree;

import java.util.*;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class _101 {
    public boolean isSymmetric(TreeNode root) {

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    /**
     * 使用双端队列
     */
    public boolean iteration1(TreeNode root) {
        // 根节点 root 为空，树被认为是对称的
        if (root == null) return true;
        // 使用 LinkedList（能插入 null）
        Deque<TreeNode> dq = new LinkedList<>();
        // 将根节点的左右子节点加入队列。
        dq.offerFirst(root.left);
        dq.offerLast(root.right);
        // 准备开始从树的第二层（即根节点的直接子节点）进行对称检查
        while (!dq.isEmpty()) {
            // 每次循环中，都从队列的两端各取一个节点（left 和 right）
            TreeNode left = dq.pollFirst();
            TreeNode right = dq.pollLast();
            // 两个节点都为空，说明当前对称位置上都没子节点
            if (left == null && right == null) continue;
            // 两个节点其中一个为空，另一个不为空，或者两个节点的值不同，说明树不对称
            if (left == null || right == null || left.val != right.val) return false;
            // 为了保持对称性检查的连续，需要按照对称的顺序将当前节点的子节点加入队列
            // 将 left 的左子节点加入队列的前端
            dq.offerFirst(left.left);
            // 将 left 的右子节点加入队列的前端
            dq.offerFirst(left.right);
            // 将 right 的右子节点加入队列的后端
            dq.offerLast(right.right);
            // 将 right 的左子节点加入队列的后端
            dq.offerLast(right.left);
        }
        // 整个过程中没有发现不对称的情况
        return true;
    }

    /**
     * 使用队列
     */
    public boolean iteration2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root.left);
        dq.offer(root.right);
        while (!dq.isEmpty()) {
            TreeNode leftNode = dq.poll();
            TreeNode rightNode = dq.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val!= rightNode.val) return false;
            dq.offer(leftNode.left);
            dq.offer(rightNode.right);
            dq.offer(leftNode.right);
            dq.offer(rightNode.left);
        }
        return true;
    }
}
