package com.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139 {
    /**
     * 解题思路：
     * 使用动态规划，定义一个布尔类型数组 dp，其中 dp[i] 表示字符串 s 的前 i 个字符是否被 wordDict 中的单词拼接得到。
     * 初始化：数组 dp 的长度为 s.length() + 1，dp[0]初始化为 true，表示空字符串总是可以被表示（即没有使用任何字典中的单词）。
     * 状态转移：对于每个位置 i 从（1 到 s.length()），遍历每个位置 j（从 0 到 i-1），
     * 检查 s.substring(j,i)（即从 j 到 i 的子字符串）是否存在于 wordDict 中，
     * 并且 dp[j] 是否为 true。如果这两个条件都满足，则将dp[i]设置为 true，并跳出当前循环
     * （因为已经找到了一种方法可以从字典中拼接出钱 i 个字符的字符串）。
     * 最后返回 dp[s.length()]的值
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转换为 hashSet 以加快搜索速度
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 找到一种拼接方式即可
                }
        return dp[s.length()];
    }
}
