package com.tree;

/**
 * 给你两棵二叉树 root 和 subRoot 。
 * 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。
 * tree 也可以看做它自身的一棵子树。
 * <a href="https://leetcode.cn/problems/subtree-of-another-tree/description">力扣</a>
 */
public class _572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 主树为空直接返回 false
        if (root == null) return false;
        // 当前节点开始的子树是否与 subRoot 匹配，或递归检查左子树或右子树
        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    /**
     * 核心思想在于遍历主树 root，寻找与子树 subRoot 根节点值相同的的节点，
     * 一旦找到，就进一步比较该节点为根的子树是否与子树 subROot 完全相同
     * 步骤 1：遍历主树寻找入口点
     * - 通过递归遍历，对每个节点，检查是否与 subRoot 的根节点值相同
     * 步骤 2：比较子树结构和节点值
     * - 当找到一个与 subRoot 根节点值相同的节点，比较从这个节点开始的子树是否与 subRoot 完全一致。
     * - 同样使用递归，同时深入两棵树的左右子树，比较相应节点的值是否相同。
     * - 在任何时刻节点值不同，或者一棵树已经遍历完而另一棵树还有节点，说明不匹配
     * 即使在某个节点找到了与 subRoot 根节点相同的节点，担子树不匹配，仍然需要继续遍历 root
     * 因为可能存在其他节点开始的子树与 subRoot 匹配
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个节点都为 null，则认为是相同的
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
