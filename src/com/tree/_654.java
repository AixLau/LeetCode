package com.tree;

/**
 * 最大二叉树
 * 给定一个不重复的整数数组 nums 。
 * 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class _654 {


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMax(nums, 0, nums.length - 1);
    }

    public TreeNode constructMax(int[] nums, int start, int end) {
        // 开始索引大于结束索引，说明子数组为空，返回null
        if (start > end) return null;
        // 查找当前数组的最大值下标
        int index = findMaxIndex(nums, start, end);
        // 创建最大值为根节点的二叉树节点
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMax(nums, start, index - 1);
        root.right = constructMax(nums, index + 1, end);
        return root;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++)
            if (maxIndex < nums[i]) maxIndex = i;
        return maxIndex;
    }

    public static void main(String[] args) {
        _654 v = new _654();
        v.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
