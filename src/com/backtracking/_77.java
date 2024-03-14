package com.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _77 {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> paths = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 创建一个空列表存放当前组合，创建一个结果列表存放所有的组合
     * 如果当前的组合的长度等于 k，说明找到了一个合法的组合，将其添加到结果列表中并返回。
     * 从当前数字开始，遍历到 n，对于每个数字，尝试将他添加到当前组合中，然后递归调用回溯函数，
     * 探索包含这个数字的所有组合。探索完后，将这个数字从当前组合中移除（回溯），以便探索不包含这个数字的组合
     */
    public void backtracking(int n, int k, int start) {
        if (paths.size() == k) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = start; i <= n - k - paths.size() + 1; i++) {
            paths.add(i);
            backtracking(n, k, i + 1);
            paths.removeLast();
        }
    }
}
