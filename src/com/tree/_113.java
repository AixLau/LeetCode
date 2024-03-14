package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @see com.tree._112
 * @see com.tree._257
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">力扣</a>
 */
public class _113 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum, new ArrayList<>());
        return result;
    }

    public void traversal(TreeNode root, int target, List<Integer> paths) {
        if (root == null) return;
        target -= root.val;
        paths.add(root.val);
        if (root.left == null &&
                root.right == null &&
                target == 0) result.add(new ArrayList<>(paths));
        if (root.left != null) {
            traversal(root.left, target, paths);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, target, paths);
            paths.remove(paths.size() - 1);
        }
    }
}
