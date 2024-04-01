package com.dp;

import com.tree.TreeNode;

public class _337 {
    /**
     * 解题思路：
     * 这个问题实际上是树形动态规划问题的一个实例，对每个节点采用递归方式，考虑两种情况：
     * 偷当前节点：这意味着不能偷其子节点，但可以考虑从其孙子节点开始偷。
     * 不偷当前节点：这意味着可以偷其子节点。
     */
    public int rob(TreeNode root) {
        int[] dp = robSub(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 该函数返回两个值：
     * 1.不偷当前房子时，能得到的最大金额。
     * 2.偷当前房子时，能得到的最大金额。
     */
    private int[] robSub(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
