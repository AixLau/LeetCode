package com.hashtable;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _503 {
    /**
     * 使用一个栈，用来存储元素索引，确保栈中的元素对应的数值是单调递减的。
     * 创建一个 ans 数组，初始化为-1。
     * 当栈不为空且当前元素大于栈顶元素索引对应的元素时，说明找到了栈顶索引元素的下一个更大元素值。
     * 将当前元素赋值给栈顶索引在 ans 中对应的位置，并弹出栈顶索引。
     * 如果是第一个遍遍历，将当前索引压入栈中。栈中存放的是索引而不是元素值。
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!dq.isEmpty() && nums[dq.peek()] < num) ans[dq.pop()] = num;
            if (i < n) dq.push(i);
        }
        return ans;
    }
}
