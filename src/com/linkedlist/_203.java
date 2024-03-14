package com.linkedlist;

public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        // 当头节点不为 null 且头节点就是要删除的元素，将下一个节点设置为头节点
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null) {
            // 当前节点的下一个节点如果不为 null 且下一个节点的值是需要删除的值
            // 那么就将指针指向下一个节点的下一个节点 直到下一个节点不是需要删除的元素为止
            while (cur.next != null && cur.next.val == val) {
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}
