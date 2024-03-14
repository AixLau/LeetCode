package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _515 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return res;
        bfs(root);
        return res;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) return;
        if (res.size() <= deep) {
            res.add(root.val);
        } else {
            Integer num = res.get(deep);
            res.set(deep, Math.max(num, root.val));
        }
        deep++;
        dfs(root.left, deep);
        dfs(root.right, deep);
    }

    public void bfs(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode node = dq.poll();
                max = Math.max(max, node.val);
                if (size == 1) {
                    res.add(max);
                }
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
            }
        }
    }
}
