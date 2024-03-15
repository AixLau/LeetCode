package com.array;


public class _205 {

    /**
     * 如果两个字符串长度不想等，那么一定不是同构的。
     * 检查两个字符串是否同构时，用两个映射表分别用来追踪 s 到 t 和 t 到 s 的字符映射。
     * 在算法中，map[c1] 表示字符 c2，map[c2] 表示 c1
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] == 0 && mapT[c2] == 0) {
                mapS[c1] = c2;
                mapT[c2] = c1;
            } else if (mapS[c1] != c2 || mapT[c2] != c1) return false;
        }
        return true;
    }
    /*
    mapS[c1] != c2：这表示字符c1应该映射到的字符不是c2。
    如果这个条件为真，说明之前已经为c1建立了一个不同于c2的映射关系，
    这违反了同构字符串的定义，因为一个字符应该始终映射到同一个字符。
    mapT[c2] != c1：这表示字符c2应该映射到的字符不是c1。
    这同样意味着之前已经为c2建立了一个不同于c1的映射关系，违反了同构字符串的定义。
    */
}

