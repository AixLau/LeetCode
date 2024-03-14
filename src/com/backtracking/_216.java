package com.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _216 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    /**
     * 在递归的每一层中，首先检查 count 是否已经超过了 n，如果是，则直接返回，
     * 如果 count 等于 n 且 path 中的数字个数恰好为 k，则找到了一个有效的组合，
     * 将其复制到一个新列表中，并添加到 result 中。
     * 遍历 start 到 9 的所有数字。循环的终止条件 9 - (k - path.size()) + 1
     * 确保了只有当剩余的数字足够填满 k 个位置时，循环才会继续。
     * 对每个数字 i，将其加入到 path 中，并更新 count 为包含这个数字的新和，
     * 然后递归探索包含当前数字的所有可能组合
     * 在递归返回后，执行回溯操作：从 path 中移除最后一个数字，并从 count 中减去该数字，
     * 以便在截下来的循环中尝试其他的数字。
     *
     * @param k     组合中应该包含的数字个数
     * @param n     目标和
     * @param start 当前递归应该从哪个数字开始尝试
     * @param count 当前 path 中所有数字的累加和
     */
    public void backtracking(int k, int n, int start, int count) {
        if (count > n) return;
        if (count == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            count += i;
            backtracking(k, n, i + 1, count);
            count -= i;
            path.removeLast();
        }
    }
}
