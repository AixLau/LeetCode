package com.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class _105 {

    /**
     * 先序遍历的第一个节点为根节点
     * 在中序遍历中找到根节点，根节点左边是左子树，根节点右边是右子树
     */
    Map<Integer, Integer> indexMap = new HashMap<>();
    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return buildTreeCur(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCur(int[] preorder, int start, int end) {
        if (start > end) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        Integer index = indexMap.get(rootVal);
        root.left = buildTreeCur(preorder, start, index - 1);
        root.right = buildTreeCur(preorder, index + 1, end);
        return root;
    }
}
