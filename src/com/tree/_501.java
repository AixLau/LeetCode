package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _501 {
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }

    Integer prev = null; // 记录前一个节点的值
    int count = 1; // 当前值的计数
    int max; // 最大频率
    List<Integer> result = new ArrayList<>(); // 存储众数的列表

    /**
     * 当访问一个节点时，首先看它的值是否和前一个节点值相同（prev）。
     * 如果相同，就增加 count（当前值出现的次数）。
     * 如果不相同，我们开始统计下一个新值，需要重置 count 为 1，
     * 并更新 prev 为当前节点值。
     * 每处理一个节点后，我们检查 count，
     * 如果 count 比 max 大，说明我们找到了一个新的更频繁出现的值。
     * 更新 max 为这个新的 count，清空 result 列表，
     * 并把当前节点值放入 result 列表。
     * 如果 count 等于 max 说明当前节点值出现的频率与之前记录的众数一眼，
     * 把当前节点值也加入 result 列表中
     */
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) if (root.val == prev) count++;
        else count = 1;
        if (count > max) {
            result.clear();
            result.add(root.val);
            max = count;
        } else if (count == max) result.add(root.val);
        prev = root.val;
        inorder(root.right);
    }

    public void iteration(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        while (!dq.isEmpty() || root != null) {
            while (root != null) {
                dq.push(root);
                root = root.left;
            }
            root = dq.pop();
            if (prev != null) if (root.val == prev) count++;
            else count = 1;
            if (count == max) result.add(root.val);
            else if (count > max) {
                max = count;
                result.clear();
                result.add(root.val);
            }
            prev = root.val;
            root = root.right;
        }
    }
}
