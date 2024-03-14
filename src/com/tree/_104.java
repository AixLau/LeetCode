package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class _104 {
    /**
     * dfs
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int deep = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size > 0) {
                TreeNode node = dq.poll();
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                size--;
            }
            deep++;
        }
        return deep;
    }

    /**
     * bfs 递归
     * 首先检查根节点 root 是否为 null。
     * 如果是，意味着树为空，因次返回深度0。
     * 这是递归的终止条件，确保递归能够访问到树的末端时正确返回。
     * 如果跟节点不为 null 则对其左右子树分别进行递归调用。
     * 分别计算左右子数的最大深度。
     * 用 Math.max() 函数比较左右子数的深度，选择两者中的较大值。
     * 这表示对于当前的节点，其最大深度是左右子树的最大深度加上当前节点自身的深度（即+1）。
     * <p>
     * 通过这种方法，递归会遍历树的每个节点，从叶子节点开始向上计算每个节点的最大深度，直到达到根节点。
     * 每个节点的最大深度是其左右子节点的最大深度的最大值+1（当前节点自身的深度贡献）
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right))+1;
    }
}
