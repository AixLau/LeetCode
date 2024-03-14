package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _199 {
    /**
     * 解题思路：层序遍历的时候，判断是否遍历到单层的最后面的元素
     * 如果是，就放到result数组中，随后返回result就可以了
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size > 0) {
                TreeNode node = dq.poll();
                if (size == 1) {
                    list.add(node.val);
                }
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                size--;
            }
        }
        return list;
    }
}

