package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                sum += node.val;
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                size--;
            }
            list.add(sum / size);
        }
        return list;
    }
}
