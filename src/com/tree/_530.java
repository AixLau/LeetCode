package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _530 {
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;

    /**
     * 初始化 prev为 null（或使用一个足够小的值，考虑 BST 节点的值可能是任意整数，
     * 可以使用 TreeNode prev 来直接引用前一个节点）
     * 进行中序遍历，遍历过程中更新 prev 和 minDiff。
     * 对于当前节点，如果 prev 不为 null，则计算当前节点的值与 prev 节点值之间的差值，
     * 并更新 minDiff 为这个差值与当前 minDiff 的较小值。
     * 更新 prev 为当前节点
     */
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorderTraversal(root.right);
    }

    /**
     * 中序迭代法
     */
    public void inorderIteration(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> dq = new ArrayDeque<>();
        while (!dq.isEmpty() || root != null) {
            while (root != null) {
                dq.push(root);
                root = root.left;
            }
            root = dq.pop();
            if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
            prev = root;
            root = root.right;
        }
    }
    

}
