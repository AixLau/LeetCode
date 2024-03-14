package com.linkedlist;

import java.util.List;

public class _206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next =pre;
            pre =cur;
            cur=temp;
        }
        return pre;
    }
}
