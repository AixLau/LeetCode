package com.stackandqueue;

import java.util.PriorityQueue;

public class _215 {
    /**
     * 使用一个大小为 k 的最小堆，遍历数组中每个元素，并将它添加到堆中。
     * 当堆的大小超过 k 时，移除堆顶元素（即堆中最小的元素）。
     * 遍历完成后，堆顶的元素就是第 k 个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
