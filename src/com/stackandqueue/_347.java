package com.stackandqueue;

import java.util.*;

public class _347 {
    /**
     * 使用最小堆（PriorityQueue）来保持频率最高的 k 个元素，
     * 使用哈希表来统计每个元素出现的频率
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 创建一个优先队列（最小堆），根据数组的第二个元素（频率）进行升序排列
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 创建一个结果数组，存储频率最高的 k 个元素
        int[] res = new int[k];
        // 使用 HashMap来统计 nums 中每个元素出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历 map 中所有的元素（即不同元素及其对应的频率）
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 创建一个临时数组用来存储元素和频率
            // 数组的第一个元素是 nums 中的值
            // 数组的第二个元素是这个值出现的频率
            int[] temp = new int[2];
            temp[0]= entry.getKey();
            temp[1] = entry.getValue();
            // 将这个数组加入到优先队列中
            pq.offer(temp);
            // 如果优先队列的大小超过了k，移除队列头部的元素（频率最小的元素）
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 将优先队列中剩下的元素（频率最高的 k 个元素）存入结果数组
        for (int i = 0; i < k; i++) {
            // 注意这里是逆序填充，因为 pq.poll()是按照升序移除的
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
