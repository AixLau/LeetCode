package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * 二叉搜索树的一个特性是：<p></p>
 * 对于树中的任意节点 x 它的左子树中的元素都要小于 x
 * 而它的右子树所有的元素值都大于 x
 * 利用这个特性使得搜索操作非常的高效，从而避免了不必要的查找
 */
public class _700 {
    public TreeNode searchBST(TreeNode root, int val) {

        return dfs(root, val);
    }

    public TreeNode dfs(TreeNode root, int val) {
        // 当前节点为空，或者我们找到了值等于 val 的节点
        if (root == null || root.val == val) return root;
        TreeNode left = dfs(root.left, val);
        if (left != null) return left;
        return dfs(root.right, val);
    }

    /**
     * 利用二叉搜索树的特性 dfs
     * 1.如果当前节点的值等于搜索值，我们就找到了目标节点，返回当前节点。
     * 2.如果当前节点的值大于搜索值，则我们应该在左子树中继续搜索。
     * 3.如果当前节点的值小于搜索值，则我们应该在右子树中继续搜索。
     * 4.如果遍历到了叶子节点仍未找到，表示树中不存在该值，返回null。
     */
    public TreeNode searchDfs(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) return searchDfs(root.left, val);
        return searchDfs(root.right, val);
    }

    public TreeNode iteration(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node.val == val) return node;
            if (node.left != null && node.val > val) {
                dq.offer(node.left);
                continue;
            }
            if (node.right != null && node.val < val) dq.offer(node.right);
        }
        return null;
    }

    /**
     * 利用二叉搜索树特性，不用栈或队列
     */
    public TreeNode searchBSTIteration(TreeNode root, int val) {
        while (root != null) if (root.val > val) root = root.left;
        else if (root.val < val) root = root.right;
        else return root;
        return null;
    }
}
