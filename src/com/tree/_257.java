package com.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _257 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root, new ArrayList<>());
        return result;
    }

    /**
     * 每次调用递归时，我们首先将当前节点的值添加到路径中<p>
     * 当前节点是叶子节点（即它没有左右子节点），就找到了一条完整的路径。
     * 使用一个 StringBuilder 来构造这条路径的字符表示，并将结果添加到结果列表中。
     * 当前节点不是叶子节点，就递归遍历它的左子节点和右子节点（它们存在的话）。
     * 再探索完一个节点的所有子节点后，我们需要从路径中移除当前节点，
     * 因为即将返回到父节点并遍历其他分支。
     * 这个步骤是回溯的一部分，确保路径只包含从根节点到当前节点的有效序列
     * <p>
     * 为什么要这样做？
     * 使用递归方法可以自然地遍历二叉树的每个节点，
     * 并在表里过程中记录路径。通过在到达叶子节点时构造路径字符串，
     * 我们能够收集所有从根节点到叶子结点的路径。
     * 回溯步骤（移除当前节点）确保遍历树的过程中，路径始终反映了从根节点到当前节点的正确序列。
     *
     * @param root  要传入的根节点
     * @param paths 记录每一条路径
     */
    public void traversal(TreeNode root, List<Integer> paths) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) sb.append(paths.get(i)).append("->");
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths);
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * 直接用字符串进行路径的记录和传递
     */
    public void traversal2(TreeNode root, String s) {
        // 当前节点为空，则没有子节点，直接返回
        if (root == null) return;
        // 当前节点是否为叶子节点
        if (root.left == null && root.right == null) {
            // 是叶子节点，将当前构建的路径加上当前节点的值后添加到结果列表中。
            result.add(s + root.val);
            return;
        }
        // 不是叶子节点，构建当前节点的路径字符串
        String temp = s + root.val + "->";
        // 递归遍历当前节点的左子树，传入更新后的路径字符串。
        traversal2(root.left, temp);
        // 递归遍历当前节点的右子树，同样传入更新后的路径字符串。
        traversal2(root.right, temp);
    }

    /**
     * 迭代法
     * 用栈存储节点极其路径，每个元素包含当前节点和一个字符串，表示从根节点到当前节点的路径
     * 遍历每个节点，检查是否为叶子节点，如果是，记录其路径。
     * 如果不是，将其非子节点及更新后的路径推入栈中继续迭代
     */
    public void iteration(TreeNode root) {
        if (root == null) return;
        Deque<Pair<TreeNode, String>> dq = new ArrayDeque<>();
        dq.push(new Pair<>(root, ""));
        while (!dq.isEmpty()) {
            Pair<TreeNode, String> pair = dq.pop();
            TreeNode node = pair.getKey();
            String path = pair.getValue();
            String curPath = path.isEmpty() ? String.valueOf(node.val) : path + "->" + node.val;
            // 如果是叶子节点，添加到结果列表
            if (node.left == null && node.right == null) result.add(curPath);
            else {
                if (node.left != null) dq.push(new Pair<>(node.left, curPath));
                if (node.right != null) dq.push(new Pair<>(node.right, curPath));
            }
        }
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
