package com.linkedlist;

import java.util.List;
import java.util.Scanner;

public class _24 {
    /**
     * 使用虚拟头节点
     */
    public ListNode swapPairs(ListNode head) {
        // 定义一个带有虚拟头节点的链表
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        ListNode cur = dumyhead;
        // 临时节点，保存两个节点中的第一个节点
        ListNode firstNode;
        // 临时节点，保存连个节点中的第二个节点
        ListNode secondNode;
        // 临时节点，保存两个节点的下一个节点
        ListNode temp;
        // 当前节点的下一个和下两个节点不为空时，开始交换
        while (cur.next != null&&cur.next.next!=null) {
            firstNode = cur.next;
            secondNode = firstNode.next;
            temp = secondNode.next;
            // 将当前节点的下一节点设置为第二个
            cur.next = secondNode;
            // 将第一个节点设置为第二个节点的下一个节点，做到交换的效果
            secondNode.next =firstNode;
            // 将两个节点之后的位置设置为第一个节点的下一个位置
            firstNode.next = temp;
            //将当前节点向右移动
            cur = firstNode;
        }
        return dumyhead.next;
    }

    /**
     * 使用递归法
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next =newNode;
        return next;
    }
}
