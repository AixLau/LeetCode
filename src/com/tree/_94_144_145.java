package com.tree;


import java.util.*;

public class _94_144_145 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(root, list);
        return list;
    }

    /**
     * 前序遍历
     */
    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 中序遍历
     */
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 后序遍历
     */
    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preorder(root.left, list);
        preorder(root.right, list);
        list.add(root.val);
    }

    /**
     * 使用栈 迭代法前序遍历
     * 前序遍历顺序：中-左-右，
     * 入栈顺序：中-右-左
     */
    public void preorderIteration(TreeNode root, List<Integer> list) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
    }

    /**
     * 中序遍历顺序: 左-中-右
     * 入栈顺序： 左-右
     */
    public void inOrderIteration(TreeNode root, List<Integer> list) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        // 遍历树
        while (!deque.isEmpty() || cur != null) {
            /*
               访问左子树，如果 cur 不为 null，则将其推入队列中，
               并将cur更新为其左子节点。持续进行，直到找到最左边的节点（即bfs），
             */
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                // 访问跟节点和右子树，当 cul 为 null 时，
                // 说明一件到达某个分支的最左边，此时聪队列中弹出顶部元素（这时上一个左子树的节点）
                // 将该节点的值添加到 list 中，表示访问这个跟节点。
                // 然后将 cur 更新为其右子节点，以同样的方式访问右子树嘿嘿
                cur = deque.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历顺序 左-右-中
     * 入栈顺序：中-左-右
     * 出栈顺序：中-右-左， 最后翻转结果
     */
    public void postorderIteration(TreeNode root, List<Integer> list) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.pop();
            list.add(node.val);
            if (node.left != null) {
                dq.push(node);
            }

            if (node.right != null) {
                dq.push(node);
            }
        }
        Collections.reverse(list);
    }

    /**
     * 通用迭代法 前序遍历
     * 这个算法的核心思想是使用一个标记（这里用的是 dummy）
     * 来指示一个节点的左右子节点已经被处理（即压入栈中），
     * 当遇到 dummy 标记时，就知道下一个弹出的节点时可以直接访问（即添加到结果列表中）的节点，
     * 因为其左右子树已经处理完毕或者它是叶子节点。
     * <p>
     * 初始时，根节点压入栈中
     * 每次循环，检查栈顶元素
     * - 如果不是 null 按照 右-左-当前节点-null 的顺序压入栈
     * 这个顺序确保了前序遍历（当前节点-左-右）被正确遵循
     * 栈是先进后出的结构
     * - 如果是 null 表示栈顶下一个节点是可以访问的节点，
     * 它的左右子节点已经被处理或它是叶子节点。
     * 从栈中移除 null 标记和该节点，将节点的值添加到结果列表
     */
    public void preorderIteration2(TreeNode root, List<Integer> list) {
        // 作为栈，用于存储将要访问的节点
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        // 将跟节点压入栈中
        dq.push(root);
        // 当栈不为空时，循环
        while (!dq.isEmpty()) {
            TreeNode node = dq.pop();
            // 检查当前节点是否为特殊标记节点
            if (node != dummy) {
                // 如果存在右子节点，将其压入栈中
                if (node.right != null) {
                    dq.push(node.right);
                }
                // 如果存在左子节点，也将其压入栈中
                if (node.left != null) {
                    dq.push(node.left);
                }
                // 将当前节点再次压入栈中，确保在左右子节点之后被处理
                dq.push(node);
                // 压入一个null作为标记，表示已经处理过当前节点
                dq.push(dummy);
                // 如果栈顶元素为null，表示遇到了之前的标记
            } else {
                node = dq.pop();
                list.add(node.val);
            }
        }
    }
}
