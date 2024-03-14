package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        checkFun02(root);
        return result;
    }

    public void checkFun01(TreeNode root, int deep) {
        // 如果当前节点为空，则返回上一层
        if (root == null) return;
        // 每深入一层，深度计数器+1
        deep++;
        // 确保result 有足够的空间来存储这层的节点值
        if (result.size()<deep){
            result.add(new ArrayList<>());
        }
        // 将当前节点的值添加到对应层对应的列表中
        // 列表索引由0开始，而层级由1开始，所以deep-1来匹配索引
        result.get(deep-1).add(root.val);
        // 递归调用当前节点的左子节点，继续遍历下一层
        checkFun01(root.left, deep);
        // 递归调用当前节点的右"子节点，继续遍历下一层
        checkFun01(root.right,deep);
    }

    /**
     * BFS-使用迭代法
     */
    public void checkFun02(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
                size--;
            }
            result.add(list);
        }
    }
}
