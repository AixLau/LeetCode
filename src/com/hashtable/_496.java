package com.hashtable;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _496 {

    /**
     * 使用一个哈希表
     * 用一个哈希表存储 nums2 中的每个元素的索引，快速找到 nums1 中每个元素在 nums2 中的位置，
     * 对于 nums1 中的每个元素，从它在 nums2 中的位置向后搜索，找到第一个比它大的元素。
     * 如果找到了，就将这个更大的元素放入答案数组中；如果没找到，就将-1 放入答案数组中。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int index = map.get(num);
            ans[i] = -1;
            for (int j = index + 1; j < nums2.length; j++)
                if (nums2[j] > num) {
                    ans[i] = nums2[j];
                    break;
                }
        }
        return ans;
    }

    /**
     * 使用一个栈和一个哈希表
     * 栈用来维护一个从栈顶到栈底单调递减的序列，哈希表用来存储 nums2 中每个元素的下一个更大元素
     * 从左到右遍历 nums2，对于每个元素，如果栈非空且当前元素大于栈顶元素，说明找到了栈顶元素的下一个更大元素。
     * 将栈顶元素弹出，同时在哈希表中记录栈顶元素和当前元素的映射关系，即栈顶元素的下一个更大元素是当前元素。
     * 当前元素小于栈顶元素或栈为空，然后将当前元素压入栈中。为 nums2 中的每个元素找到其下一个更大的元素并存储在哈希表中
     * 遍历 nums1 的每个元素，根据哈希表找到对应的下一个更大元素，如果存在，则加入到答案数组中；
     * 如果不存在，则加入默认值-1。
     */
    public int[] test(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int num : nums2) {
            while (!dq.isEmpty() && num > dq.peek()) map.put(dq.pop(), num);
            dq.push(num);
        }
        for (int i = 0; i < nums1.length; i++) ans[i] = map.getOrDefault(nums1[i], -1);
        return ans;
    }
}
