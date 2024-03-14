package com.tree;

public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        int rootVal = nums[mid];
        TreeNode node = new TreeNode(rootVal);
        node.left = traversal(nums, left, mid - 1);
        node.right = traversal(nums, mid + 1, right);
        return node;
    }
}
