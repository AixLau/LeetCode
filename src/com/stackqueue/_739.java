package com.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class _739 {
    /**
     * 单调栈
     * 当栈不为空且当前元素的温度大于栈顶元素索引对应的温度时
     * 弹出栈顶元素，代表找到一个更高的温度。
     * 计算当前天书与栈顶元素索引对应的天数之间的差值，这就是下一个更高温度出现在几天后。
     * 将这个差值存储在结果数组的相应位置。
     * 将当前元素的索引压入栈中
     * 对于栈中仍然存在的索引，它们对应的天数没有更高的温度，
     * 所以结果数组这些位置的值保持初始化 0 即可。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]) {
                int index = dq.pop();
                answer[index] = i - index; // 计算天数差
            }
            dq.push(i); // 将当前天的索引压入栈
        }
        // 对于栈中剩余的元素，不需要做任何操作，因为对应的ans数组位置已经默认为0
        return answer;
    }
}
