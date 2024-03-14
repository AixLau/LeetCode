package com.linkedlist;


import java.util.HashSet;

public class _142 {
    /**
     * 使用 哈希表来表解题
     * 表中没有该节点，将节点添加到表中，当表包含该节点说明该节点就是环的入口
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode dummy = head;
        while (dummy != null) {
            if (set.contains(dummy.next)) {
                return dummy.next;
            } else {
                set.add(dummy);
                dummy = dummy.next;
            }
        }
        return null;
    }

    /**
     * 使用双指针 快慢指针解决
     */
    public ListNode detectCycle2(ListNode head) {
        // 定义快慢指针 快指针比慢指针多走1步
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /*
             当快慢指针在环里相遇了说明有环
             假设慢指针走到环口的距离为 x
             快指针从环口到相遇的距离为 y
             相遇的位置走到环口的距离为 z
             2（x + y） = x+y+ N(y+z)
                x + y = N(y+z)
                x = N(y+z)-y
                x = (N-1)(y+z)+z
                快指针至少循环了一圈 当n=1时
                x = z
                也就是从起始点到环口的距离与相遇点到环口的距离相等
                这时同时从起始点和相遇点出发，直到相遇，这时就是环口
             */
            if (fast == slow) {
                ListNode i = head;
                ListNode j = fast;
                while (i != j) {
                    i = i.next;
                    j = j.next;
                }
                return i;
            }
        }
        return null;
    }
}
