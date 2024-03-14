package com.backtracking;

import java.util.*;

public class _40 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            target -= candidates[i];
            backtracking(candidates, target, i + 1);
            target += candidates[i];
            path.removeLast();
        }
    }
}
