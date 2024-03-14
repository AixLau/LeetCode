package com.tree;

public class _112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return traversal(root, targetSum);
    }

    public boolean traversal(TreeNode root, int target) {
        if (root == null) return false;
        target -= root.val;
        if (root.left == null && root.right == null) return target == 0;
        return traversal(root.left, target) || traversal(root.right, target);
    }
}
