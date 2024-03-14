package com.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _491 {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return result;
    }


    private void backtrack(int[] nums, int start) {
        if (path.size() > 1) result.add(new ArrayList<>(path));
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || used[nums[i] + 100]) continue;
            path.add(nums[i]);
            used[nums[i] + 100] = true; // 标记本层元素已使用
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
