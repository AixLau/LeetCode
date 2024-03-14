package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode dfs = mergeDfs(root1, root2);
        TreeNode stackIteration = mergeDfs(root1, root2);
        return dfs;
    }

    /**
     * 如果node1和node2的子节点都存在：这意味着两个树在这个位置都有节点，所以我们需要将这两个节点的值相加，并且继续考虑他们的子节点合并问题。在你的代码中，这一点通过将node1和node2的左右子节点分别推入栈中来实现。
     * 如果node1的子节点不存在，而node2的子节点存在：这意味着root1在这个位置缺少节点，但root2有节点。为了合并，我们直接将root2的相应子节点赋给root1的相应位置。这种方式，root1就包含了root2在这个位置的值。
     * 如果node2的子节点不存在，而node1的子节点存在：这种情况下，我们不需要做任何事，因为root1已经有了一个节点在这个位置，而root2没有提供新的值来合并。所以，代码中没有明确处理node2为空的情况，因为它自然而然地不需要额外操作。
     */

    public TreeNode mergeDfs(TreeNode root1, TreeNode root2) {
        // 如果期中一个节点为空，就返回另一个节点
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 否则，把两个节点的值相加，合并到 root1 上
        root1.val += root2.val;

        // 递归合并左子树和右子树
        root1.left = mergeDfs(root1.left, root2.left);
        root1.right = mergeDfs(root1.right, root2.right);
        return root1;
    }

    /**
     * 使用栈迭代
     */
    public TreeNode stackIteration(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root2);
        dq.push(root1);
        while (!dq.isEmpty()) {
            TreeNode node1 = dq.pop();
            TreeNode node2 = dq.pop();
            node1.val += node2.val;
            if (node1.right != null && node2.right != null) {
                dq.push(node2.right);
                dq.push(node1.right);
            } else if (node1.right == null) node1.right = node2.right;
            if (node1.left != null && node2.left != null) {
                dq.push(node2.left);
                dq.push(node1.left);
            } else if (node1.left == null) node1.left = node2.left;
        }
        return root1;
    }

    /**
     * 使用队列迭代
     */
    public TreeNode queueIteration(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root1);
        dq.offer(root2);
        while (!dq.isEmpty()) {
            TreeNode node1 = dq.poll();
            TreeNode node2 = dq.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                dq.offer(node1.left);
                dq.offer(node2.left);
            } else if (node1.left == null) node1.left = node2.left;
            if (node1.right != null && node2.right != null) {
                dq.offer(node1.right);
                dq.offer(node2.right);
            } else if (node1.right == null) node1.right = node2.right;
        }
        return root1;
    }
}
