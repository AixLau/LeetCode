package com.stackandqueue;

import java.util.ArrayDeque;

public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 如果队列不为空且队列的头部元素（即当前窗口的最大值下标）
            // 不在当前考虑的窗口内（即小于i-k+1），则从队列中移除这个头部元素
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 在添加一个新元素之前，需要保证队列的单调递减性
            // 如果当前元素大于队列尾部的元素，那么将队列尾部的元素移除，直到队列再次成为单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 添加当前元素
            deque.offer(i);
            // 一旦窗口的大小达到了k（即i>=k-1），
            // 就可以开始从队列的头部提取最大值的下标，
            // 并将对应的元素存储存储到结果数组 res 中
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
