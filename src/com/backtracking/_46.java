package com.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _46 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used) {
        // 如果当前路径的长度等于数组的长度，说明找到了一个完整的排列。
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经被使用，则跳过
            if (used[i]) continue;
            // 否则将当前数字添加到路径中，并标记为已使用。
            path.add(nums[i]);
            used[i] = true;
            // 递归填充下一个数字
            backtrack(nums, used);
            // 回溯：将当前数字从路径中移除，并标记为未使用。
            path.removeLast();
            used[i] = false;
        }
    }
}
