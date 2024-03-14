package com.backtracking;

import java.util.*;

public class _39 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    /**
     * 代码一开始通过 Arrays.sort(candidates) 对候选数组进行了排序。
     * 使得当 sum + candidates[i] > target 时，可以直接终止循环。
     * 因为数组是排序的，当前元素之后的所有元素都 会大于或等于当前元素。
     * 如果sum > target，说明当前路径不可能得到有效的组合，直接返回。
     * 如果sum == target，说明当前路径得到了一个有效的组合，将其添加到结果列表result中。
     */
    public void backtracking(int[] candidates, int target, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (sum + candidates[i] > target) break;
            list.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
