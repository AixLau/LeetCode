package com.tree;

public class _701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        traversal(root, val);
        return root;

    }

    /**
     * 1.如果根节点为空，直接再根节点位置创建一个新节点存储要插入的值，返回这个新节点作为树的根节点。
     * 2.如果要插入的值小于当前节点的值，递归地在当前节点的左子树中插入这个值。
     * 如果当前节点的左子树为空，就在这里创建一个新节点存储要插入的值，并将其作为当前节点的左子节点。
     * 3.如果要插入的值大于当前节点的值，递归地在当前节点的右子树中插入这个值。
     * 如果当前节点的右子节点为空，就在这里创建一个新节点存储要插入的值，并将其作为当前节点的右子节点。
     * 4.返回根节点，这样保证了插入操作后，整棵树的结构仍然是一个 BST
     */
    public TreeNode traversal(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = traversal(root.left, val);
        if (root.val < val) root.right = traversal(root.right, val);
        return root;
    }

    /**
     * 迭代法
     */
    public TreeNode iteration(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newTree = root;
        TreeNode prev = root;
        while (root != null) {
            prev = root;
            if (root.val > val) root = root.left;
            else if (root.val < val) root = root.right;
        }
        if (prev.val > val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return newTree;
    }
}
