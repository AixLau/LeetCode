package com.tree;

public class _450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        return delete(root, key);
    }


    public TreeNode delete(TreeNode root, int key) {
        // 当 root 为 null 时，表示树为空或者已经达到叶子节点的下一层
        if (root == null) return null;
        // 找到了要删除的节点 情况 1：如果要删除的节点时叶子节点，直接删除
        if (root.val == key) if (root.left == null && root.right == null) return null;
            // 情况 2：如果要删除的节点只有右子节点，用右子节点代替当前节点的位置
        else if (root.left == null) return root.right;
            // 情况 3：如果要删除的节点只有左子节点，用左子结点替代当前节点的位置
        else if (root.right == null) return root.left;
            // 情况 4：如果要删除的节点既有左子结点又有右子节点
        else {
            // 找到删除节点右子树中最小节点（即右子树中最左边的节点）
            TreeNode cur = root.right;
            while (cur.left != null) cur = cur.left;
            // 将要删除节点的左子树附加到找到的最小节点的左指针上
            cur.left = root.left;
            // 返回右子节点替代当前节点，因为右子树的最小节点已经移动到要删除节点的位置
            return root.right;
        }
        // 如果 key 小于当前节点值，说明要删除的节点在左子树中
        if (root.val > key) root.left = delete(root.left, key);
        // 如果 key 大于当前节点值，说明要删除的节点在右子树中
        if (root.val < key) root.right = delete(root.right, key);
        return root;
    }

    /**
     * 1.定位要删除的节点：从根节点开始，根据 key 的值定位到要删除的节点。
     * 2.删除节点：找到节点后，根据节点的子节点的数量处理删除操作。
     * 如果节点时叶子节点（没有左右子节点），可以直接删除。
     * 如果节点只有一个子节点，可以将这个子节点提升到被删除节点的位置。
     * 如果节点有两个子节点，则找到节点的右子树中最小值节点（或左子树中的最大值节点），
     * 将其值复制到要删除的节点，然后删除哪个最小（或最大）值节点。
     */
    public TreeNode delete2(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = delete2(root.left, key);
        else if (key > root.val) root.right = delete2(root.right, key);
        else if (key == root.val) {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // 在右子树中找到最小节点
            TreeNode minNode = findMin(root.right);
            // 用最小节点的值替换要删除节点的值
            root.val = minNode.val;
            // 从右子树中删除最小节点
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
