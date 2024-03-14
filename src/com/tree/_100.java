package com.tree;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class _100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return false;
    }

    public boolean checkSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val != q.val) return false;
        return checkSame(p.left, q.left) && checkSame(p.right, q.right);
    }

    /**
     * 使用 ^ 异或
     * ^ 当两个条件中只有一个为时才为真
     */
    public boolean checkSame2(TreeNode p, TreeNode q) {
        /*
            当 p 等于 null 时，q 不等于 null 说明不相同
            当 p 不等于 null 时，q 等于 null 时说明不相同
            当 p 等于 null 时，q 也等于 null 时说明相等
            因为 ^ 只有一个为真时才为真 pq 都是 null 两个真就是假
         */
        if (p == null && q == null) return true;
        if (p == null ^ q == null || p.val != q.val) return false;
        return checkSame2(p.left, q.left) && checkSame(p.right, q.right);
    }
}
