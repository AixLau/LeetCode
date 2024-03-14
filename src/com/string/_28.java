package com.string;

public class _28 {
    /**
     * 使用KMP算法
     */
    public int strStr(String haystack, String needle) {
        int[] prefix = new int[needle.length()];
        int ans = -1;
        getPrefix(prefix, needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) j++;
            if (j == needle.length()) return i-needle.length()+1;
        }
        return -1;
    }

    public void getPrefix(int[] prefix, String s) {
        for (int j = 0, i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = prefix[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                prefix[i] = ++j;
            }
        }
    }
    /**
     * 基于窗口滑动的算法
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public int strStr2(String haystack, String needle) {
        int m = needle.length();
        if (m==0) {
            return 0;
        }

        int n = haystack.length();
        if (n < m) {
            return -1;
        }
        
        int i=0,j=0;
        while (i < n - m + 1) {

            while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == n) {
                return -1;
            }

            while (i < n && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return i-j;
            } else {
                i-=j-1;
                j=0;
            }

        }
        
        return -1;
    }
}
