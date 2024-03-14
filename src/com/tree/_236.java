package com.tree;

public class _236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return postorderTraversal(root, p, q);
    }

    /**
     * 算法思路：
     * 递归终止条件：当前节点为 null，或者等于 p 或 q，则返回当前节点。
     * 递归左右子树：对当前的左右子树进行递归调用，分别查找 p 和 q。
     * 处理递归返回值：
     * 如果左右递归调用都返回了非空节点（意味着找到了p 和 q），则当前节点就是最近公共祖先。
     * 如果只有左子树递归返回了非空节点，则说明 p 和 q 都在 q 左子树中，返回该左子树递归的结果。
     * 如果只有右子树递归饭量非空节点，说明 p 和 q 都在右子树中个，返回该右子树递归的记过。
     * 如果左右子树递归都返回空，说明当前子树中不包含 p 和 q，返回 null
     */
    public TreeNode postorderTraversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = postorderTraversal(root.left, p, q);
        TreeNode right = postorderTraversal(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null && right != null) return right;
        else return left;
    }

    /**
     * 简化代码
     */
    public TreeNode postorder(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null || root == p || root == q) return root;
        TreeNode left = postorder(root.left, p, q);
        TreeNode right = postorder(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
