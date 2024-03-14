package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _116 {
    /**
     * bfs
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            // 当前层的节点数量
            int size = dq.size();
            // 遍历当前层的全部节点
            for (int i = 0; i < size; i++) {
                // 从队列中移除节点
                Node node = dq.poll();
                // 如果不是当前层的最后一个节点，则将next设置为队列的下一个节点
                if (i < size - 1) {
                    node.next = dq.peek();
                }
                // 将当前节点的左右子节点添加到队列中
                // 由于是完美二叉树，可以保证非叶子节点必有两个子节点
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) return null;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            // 从队列中取出当前层的第一个节点（即最左边的节点）
            Node cur = dq.poll();
            // 将当前节点的左右子节点加入队列（如果有的话）
            if (cur.left != null) dq.offer(cur.left);
            if (cur.right != null) dq.offer(cur.right);
            // 对当前层的其余节点进行遍历
            for (int i = 1; i < size; i++) {
                // 从队列中取出下一个节点
                Node next = dq.poll();
                // 同样，将下一个节点的左右子节点加入队列（如果有的话）
                if (next.left != null) dq.offer(next.left);
                if (next.right != null) dq.offer(next.right);
                // 将当前节点的 next 指向下一个节点
                cur.next = next;
                // 更新当前节点，以便下次迭代
                cur = next;
            }
            /*
              循环结束后
              根据完美二叉树的定义，最后一个节点的next应该指向 null
              这是 Java 中对象属性的默认值，所以这里不需要显示设置
             */
        }
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        public Node() {
        }
    }
}
