package com.linkedlist;

public class _02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        // 遍历出两个节点的长度
        while (dummyA != null) {
            sizeA++;
            dummyA = dummyA.next;
        }
        while (dummyB != null) {
            sizeB++;
            dummyB = dummyB.next;
        }

        dummyA = headA;
        dummyB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                dummyA = dummyA.next;
            }
        } else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                dummyB = dummyB.next;
            }
        }
        while (dummyA != null && dummyB != null) {
            if (dummyA == dummyB) {
                return dummyA;
            }
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return null;
    }
}
