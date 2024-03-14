package com.tree;

import java.util.Deque;
import java.util.LinkedList;

public class _98 {
    public boolean isValidBST(TreeNode root) {

        return isValidIn(root);
    }

    /**
     * 使用中序遍历迭代法
     * 我们确保每个节点的值都必须大于前一个节点的值。如果发现不满足这个条件的情况，立即返回false。
     * 使用 prevNode 来跟踪上一个处理的节点
     * 每次从栈中取出节点，比较它与 prevNode 的值，当前节点值不大于 prevNode 的值
     * 那么这颗树不满足二叉搜索树的定义，返回 false。
     * 遍历完没有发现任何违反二叉树性质的行为，那么树是有效的二叉搜索树，返回 true
     */
    public boolean isValidIn(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归的终止条件：当前节点为 null 时，说明到达了叶子节点的下一层，按照 BST 的定义，这时合法的 return true
     * 节点值的合法性检查：对于当前的节点，如果它的值不在（min，max）的范围内，说明这个子树不复合 BST 的定义 return false
     * 对左右子树进行递归检查：
     * -对于左子树，它的所有值都要小于当前节点的值，因此，我们将当前节点的值作为
     * 左子树的最大值进行递归检查，而最小值保持不变
     * -对于右子树，它的所有值都必须大于当前节点的值。因此我们将当前节点的值作为右子树的最小值进行递归，而最大值保持不变
     * 递归的返回值：返回左右子树检查逻辑与结果。只有左右子树都符合 BST 的性质时，当前的子树才是有效的 BST
     */
    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
    /**
     * 工作示例
     * 假设我们有一个二叉树：[10,5,15,null,null,6,20]。初始调用是validate(root, Long.MIN_VALUE, Long.MAX_VALUE)。
     * <p>
     * 对于根节点10，它确实在Long.MIN_VALUE和Long.MAX_VALUE之间。然后，我们对它的左右子树进行递归检查。
     * 左子节点5的递归调用是validate(5, Long.MIN_VALUE, 10)，因为5的值需要小于10。
     * 右子节点15的递归调用是validate(15, 10, Long.MAX_VALUE)，因为15的值需要大于10。
     * 当递归到节点6时，调用是validate(6, 10, 15)。由于6不满足10 < val < 15的条件，返回false。
     */
}
