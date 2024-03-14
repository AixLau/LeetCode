package com.tree;

import sun.net.idn.Punycode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class _222 {
    public int countNodes(TreeNode root) {
        int sum = dfs(root);
        return sum;
    }

    public int dfs(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            sum++;
            TreeNode node = dq.poll();
            if (node.left != null) dq.offer(node.left);
            if (node.right != null) dq.offer(node.right);
        }
        return sum;
    }

    public int recursion(TreeNode root, int count) {
        if (root == null) return count;
/*      count++;
        count =recursion(root.left, count);
        return recursion(root.right, count); */
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
