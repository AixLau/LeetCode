package com.string;

public class _459 {
    public boolean repeatedSubstringPattern(String s) {
        // 检查字符串是否为空
        if (s.isEmpty()) {
            return false;
        }
        // 获取字符串的长度
        int len = s.length();
        // 将字符串转为字符数组
        char[] chars = s.toCharArray();
        // 创建next数组，用于存储每个字符的最长相等前后缀的长度
        int[] next = new int[len];

        // 构建next数组
        for (int i = 1, j = 0; i < chars.length; i++) {
            // 当前缀与后缀不匹配时，回溯找到之前匹配的最长前缀
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            // 如果当前字符匹配，增加匹配长度
            if (chars[i] == chars[j]) {
                // 更新next数组的值
                next[i] = ++j;
            }
        }
        /*
        判断字符串是否由重复的子串构成
        条件1:next[len-1]!=0，确保存在最长相等前后缀
        条件2:len %(len-next[len-1]==0，确保字符串长度可以被剩余长度整除
        这意味着整个字符串可以完全由其一个子串重复多次构成
         */
        if (next[len - 1] != 0 && len % (len - (next[len - 1])) == 0) {
            return true;
        }
        return false;
    }
}
