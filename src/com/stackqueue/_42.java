package com.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class _42 {
    /**
     * 利用单调栈找出每个柱子左右两侧第一个高于它的柱子
     * 创建一个栈来存储柱子的索引。
     * 当栈不为空且当前柱子的高度大于栈顶柱子索引对应的高度时，
     * 说明找到了一个可以接雨水的凹槽。
     * 计算当前柱子与栈顶柱子索引之间的距离，这代表凹槽的宽度。
     * 计算栈顶柱子的高度与其左侧和右侧高度的最小值，这代表凹槽的深度。
     * 将凹槽的宽度与深度相乘，得到凹槽可以接的雨水量，并累加到总量中。
     * 将当前柱子的索引压入栈中。
     */
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!dq.isEmpty() && height[i] > height[dq.peek()]) {
                int top = dq.pop();
                if (dq.isEmpty()) break;
                int distance = i - dq.peek() - 1;
                int boundedHeight = Math.min(height[i], height[dq.peek()]) - height[top];
                sum += distance * boundedHeight;
            }
            dq.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        _42 solution = new _42();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height)); // 输出结果
    }
}
