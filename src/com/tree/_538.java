package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _538 {
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }


    int count = 0;

    /**
     * 对于树中的每一个节点，它在累加树中的新值是原始数中所有大于或等于该节点值和节点值之和。
     * 为了实现这个转换，我们需要从最大的节点（即最右侧的节点）开始，逐渐累加节点的值，直到最小的节点（即最左侧的节点）。
     * 核心在于维护一个全局的累加变量，用于记录当前节点及其右侧所有节点的值的累加和。
     * <p>
     * 从根节点开始，首先递归进其右子树。这是为了找到并开始处理最大的节点。
     * 处理完右子树后，回到当前节点，将累加变量加上当前节点值，然后更新当前节点的值为 sum。
     * 确保了当前节点的新值等于原数中大于或等于该节点值的节点值之和。
     * 接着，递归进左子树，重复上述过程。因为我们是在处理比当前节点小的值，所以 sum 已经包含了当前节点及其右侧所有节点的累加和
     */
    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        count += root.val;
        root.val = count;
        traversal(root.left);
    }

    /**
     * 使用栈存储节点：迭代遍历时，使用栈来暂时存储访问路径上的节点，以便能够按照逆中序遍历的顺序访问每个节点
     * 遍历到最右节点：通过不断遍历右子节点并将它们压入栈中，可以确保首先访问到最大的节点。
     * 处理节点并转向左子树：每从栈中弹出一个节点，就更新累加变量并修改节点的值，然后转向处理它的左子树
     * （因为左子树中的节点值都比当前节点小，需要用更新的 sum 来修改它们 0
     */
    public void iteration(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        while (!dq.isEmpty() || root != null) {
            while (root != null) {
                dq.push(root);
                root = root.right;
            }
            root = dq.pop();
            count += root.val;
            root.val = count;
            root = root.left;
        }
    }
}
