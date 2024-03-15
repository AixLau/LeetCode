package com.greed;

public class _968 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0) res++;
        return res;
    }

    /**
     * 对每个节点，存在三种状态：
     * 1.当前节点安装了摄像头
     * 2.当前节点没有安装摄像头，但是被监控了。
     * 3.当前节点没有被监控。
     * 基于这三种状态，定义一个递归函数，该函数返回每个节点的状态。
     * 为了最小化摄像头的数量，采用以下策略：
     * 如果节点的任意一个子节点没有被监控，那么这个节点需要安装摄像头。
     * 如果节点的任意一个子节点安装了摄像头，那么这个节点被监控了。
     * 如果节点的所有子节点都被监控了，但是都没安装摄像头，那么这个节点没有被监控，
     * 它的父亲节点需要安装摄像头或者已经被其它节点的摄像头监控。
     */
    public int minCame(TreeNode root) {
        if (root == null) return 2;
        int left = minCame(root.left);
        int right = minCame(root.right);
        if (left == 2 && right == 2) return 0;
        else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else return 2;
    }


}
