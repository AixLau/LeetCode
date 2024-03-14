package com.array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class _76 {
    /**
     * 使用滑动窗口的思想解题
     */
    public String minWindow(String s, String t) {
        // 存储最小覆盖子串
        String ans = "";
        // 用来记录当前窗口中满足条件（即 t 中字符出现次数）的字符数量
        int cnt = 0;
        // 记录当前找到的最小子串长度
        int len = Integer.MAX_VALUE;
        // 用于存储当前窗口中各字符出现次数
        Map<Character, Integer> hs = new HashMap<>();
        // 用于存储字符串 t 中各字符出现次数
        Map<Character, Integer> ht = new HashMap<>();

        // 初始化 ht 遍历字符串 t 记录每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            ht.put(ch, ht.getOrDefault(ch, 0) + 1);
        }

         /*
         使用滑动窗口遍历 s
         通过双指针 i 和 j表示窗口的起始和结束的位置
         不断扩大和缩小窗口 寻找最小覆盖子串
         */
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 每次移动 i （窗口右边界）都会将s.charAt(i) 的计数增加
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
            // 如果当前字符是 t 中的字符 且其出现次数不超过 t中的出现次数 cnt加1
            if (ht.containsKey(ch) &&
                    hs.get(ch) <= ht.get(ch)) {
                cnt++;
            }

            /*
            调整窗口左边界 通过移动 j（窗口左边界）缩小窗口
            同时保证窗口内仍然包含 t 中的所有字符
            如果当前 j 指向的字符串不在 t 中， 或者出现次数超过了 t 中该字符出现次数
            就移动 j 直到不能再缩小为止
            */
            while (j < i &&
                    (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }

            // 更新最小子串： 如果当前窗口中的字符满足 t 的全部要求 （即cnt等于t长度）
            // 并且当前窗口的长度小于已找到的最小长度，则更新答案
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }
    public String minWindow1(String s, String t) {
        // 存放答案，如果找不到默认为 “”
        String ans = "";
        // 存放t的长度 当达到 cnt = t.lenght 说明该子串完整包含了t
        int cnt=0;
        int len=Integer.MAX_VALUE;
        // 存放 t 字符串 中字符出现的次数
        HashMap<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            ht.put(ch, ht.getOrDefault(ch, 0) + 1);
        }
        // 存放 s 字符串 各字符出现的次数 主要是判断 有没有超过 t 字符串 中的字符个数
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
            // 如果 t 中包含了 该字符 并且 在hs表中出现的个数少于或者等于 ht出现的个数
            // 就在 cnt 中增加
            if (ht.containsKey(ch)
                    && hs.get(ch) <= ht.get(ch)) {
                cnt++;
            }
            while (j < i
                    // 当前的字符不是 t 的 字符就向右滑动窗口
                    // 或者是当前字符在hs表中出现的次数多于 ht表中
                    // 说明当前子串多包含了 t中的一个字符 需要向右滑动窗口
                    // 在hs表中移除掉当前的字符
                    && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                hs.put(s.charAt(j), hs.get(s.charAt(j))-1);
                j++;
            }
            // cnt = t.lenght 说明 窗口的子串完全包含 t的所有字符
            // 并且当前窗口小于之前记录的窗口，那么将当前窗口的大小覆盖原来记录
            if (cnt == t.length() && i - j + 1 < len) {
                len = i-j+1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }
}
