package com.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class _107 {
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 该题目的解题思路是用广度优先搜索算法
     * 层序遍历，在将结果反转
     **/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return result;
        checkFun01(root);
        Collections.reverse(result);
        return result;
    }

    public void checkFun02(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        if (result.size() < deep) result.add(new ArrayList<>());
        result.get(deep - 1).add(root.val);
        checkFun02(root.left,deep);
        checkFun02(root.right, deep);
    }

    public void checkFun01(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = dq.size();
            while (size > 0) {
                TreeNode node = dq.poll();
                list.add(node.val);
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                size--;
            }
            result.add(list);
        }
    }
}
