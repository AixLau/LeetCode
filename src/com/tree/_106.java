package com.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class _106 {
    // 存储中序遍历元素的索引，快速找到分割点，不用每次都去线性查找
    Map<Integer, Integer> indexMap = new HashMap<>();
    // 后序遍历的最后一个元素索引，也就是根节点
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // 填充 HashMap
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        // 从后序遍历的最后一个元素（根节点）开始，递归构建整棵树
        return buildTreeRecursively(postorder, 0, inorder.length - 1);
    }


    /**
     * 1.后序遍历数组的最后一个元素为根节点。
     * 2.在中序遍历数组中找到根节点，根节点左边的就是左子树，右边的就是右子树。
     */
    public TreeNode buildTreeRecursively(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        // 获取根节点，并将索引向前移动
        int rootVal = postorder[postIndex--];
        // 创建根节点
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的索引
        int index = indexMap.get(rootVal);
        // 先构建右子树，再构建左子树，因为在后序遍历中，右子树在根节点之前，左子树在右子树之前。
        root.left = buildTreeRecursively(postorder, inStart, index - 1);
        root.right = buildTreeRecursively(postorder, index + 1, inEnd);
        return root;
    }
}
