package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _219 {
    /**
     * 使用 HashMap
     * 我们遍历数组，对于每个元素，我们检查哈希表中是否已经有了该元素，
     * 如果有，并且当前索引与哈希表中存储的索引之差不超过k，
     * 那么我们就找到了满足条件的两个不同索引，返回true。
     * 如果没有找到，我们继续更新哈希表中该元素对应的索引。
     * 这种方法的时间复杂度是O(n)，其中n是数组nums的长度，因为我们只需要遍历一次数组。
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 使用滑动窗口
     * 创建一个哈希集合用于存储当前窗口内的元素
     * 遍历 nums 的每个元素。对每个元素 nums[i]，检查它是否存在哈希集合中。
     * 如果是，返回 true，因为这意味着在距离 k 以内存在相同的元素。
     * 如果不是，当将当前元素添加到哈希集合中。
     * 如果窗口的实际大小超过了 k，就从哈希集合中移除醉倒进入窗口的元素 nums[i-k]
     * 如果遍历完没找到满足条件元素，返回 false。
     */
    public boolean contains(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}
