package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _110 {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    /**
     * 递归法
     * 后序遍历
     * 核心思想是用来检查一个二叉树是否是高度平衡的，
     * 并且在这个过程中计算树的高度。
     * 一个高度平衡的二叉树定义为一个二叉树，
     * 其中每个节点的两个子树的深度差不会超过1。
     */
    public int checkBalance(TreeNode root) {
        // 当前节点为 null，表示树的高度为 0（空树是平衡的），
        if (root == null) return 0;
        // 对左子结点递归，计算左子结点的高度
        int leftHeight = checkBalance(root.left);
        // 左子树的高度为-1（这是特殊标记，表示子树不平衡），
        // 立即返回-1，表示整棵树不平衡。这一步是优化关键，
        // 避免了对右子树的不必要计算
        if (leftHeight == -1) return -1;
        // 与上述左子树递归同理
        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;
        // 左右子树的高度差的绝对值超过了 1，则返回-1，表示当前树不平衡
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        // 如果树平衡，返回左右子树中最大高度+1（当前节点的高度）
        return Math.max(rightHeight, leftHeight) + 1;
    }

    /**
     * 迭代法
     * 使用一个栈来存储节点 以及一个 HashMap 来记录每个节点的高度
     */
    public boolean isBalance(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> dq = new ArrayDeque<>();
        return false;
    }
}
