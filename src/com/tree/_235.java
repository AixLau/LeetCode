package com.tree;

public class _235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return postorder(root, p, q);
    }

    /**
     * 使用后序遍历、回溯 自下而上
     */
    public TreeNode postorder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = postorder(root.left, p, q);
        TreeNode right = postorder(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * 使用前序 自上而下
     * 祖先的值 p~q 之间
     * 如果 中间节点是 q 和 p 的公共祖先
     * 那么 中节点的数组 一定是在 [p, q]区间的。
     * 即 中节点 > p && 中节点 < q 或者 中节点 > q && 中节点 < p。
     */
    public TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return traversal(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return traversal(root.right, p, q);
        return root;
    }
}
